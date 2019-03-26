package gov.acwi.wqp.etl.wqpNemiNwisCrosswalk;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class TransformWqpNemiNwisCrosswalk {
	@Autowired
	@Qualifier("wqpDataSource")
	private DataSource wqpDataSource;

	@Autowired
	@Qualifier("nemiDataSource")
	private DataSource nemiDataSource;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public JdbcCursorItemReader<WqpNemiNwisCrosswalk> wqpNemiNwisCrosswalkReader() {
		return new JdbcCursorItemReaderBuilder<WqpNemiNwisCrosswalk>()
				.dataSource(nemiDataSource)
				.name("nemiCrosswalk")
				.sql("select analytical_procedure_source, analytical_procedure_id, citation_method_num, method_id, wqp_source, method_type " 
						+ "from (select wqp_nemi_nwis_crosswalk.*, count(*) over (partition by analytical_procedure_source, analytical_procedure_id) cnt from wqp_nemi_nwis_crosswalk) " 
						+ "where cnt = 1")
				.rowMapper(new WqpNemiNwisCrosswalkRowMappper())
				.build();
	}

	@Bean
	public WqpNemiNwisCrosswalkProcessor wqpNemiNwisCrosswalkProcessor() {
		return new WqpNemiNwisCrosswalkProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<WqpNemiNwisCrosswalk> wqpNemiNwisCrosswalkWriter() {
		return new JdbcBatchItemWriterBuilder<WqpNemiNwisCrosswalk>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO wqp_nemi_nwis_crosswalk " + 
						" (analytical_procedure_source, analytical_procedure_id, citation_method_num, method_id, wqp_source, method_type, nemi_url) " 
						+ "VALUES (:analyticalProcedureSource, :analyticalProcedureId, :citationMethodNum, :methodId, :wqpSource, :methodType, :nemiUrl)")
				.dataSource(wqpDataSource)
				.build();
	}
}

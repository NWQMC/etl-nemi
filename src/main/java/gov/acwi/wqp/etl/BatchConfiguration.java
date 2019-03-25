package gov.acwi.wqp.etl;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	@Qualifier("wqpNemiNwisCrosswalkFlow")
	private Flow wqpNemiNwisCrosswalkFlow;
	
	@Bean
	public Job nemiEtlJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("nemiEtlJob")
				.listener(listener)
				.start(wqpNemiNwisCrosswalkFlow)
				.build()
				.build();
	}

}

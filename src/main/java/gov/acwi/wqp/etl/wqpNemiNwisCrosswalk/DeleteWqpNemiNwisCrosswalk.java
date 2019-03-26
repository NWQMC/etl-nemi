package gov.acwi.wqp.etl.wqpNemiNwisCrosswalk;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import gov.acwi.wqp.etl.BaseDeleteTable;

@Component
@StepScope
public class DeleteWqpNemiNwisCrosswalk extends BaseDeleteTable {
	
	@Autowired
	public DeleteWqpNemiNwisCrosswalk(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "wqp_nemi_nwis_crosswalk");
	}
}
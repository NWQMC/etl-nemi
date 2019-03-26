package gov.acwi.wqp.etl.wqpNemiNwisCrosswalk;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WqpNemiNwisCrosswalkRowMappper implements RowMapper<WqpNemiNwisCrosswalk> {
	
	public static final String ANALYTICAL_PROCEDURE_SOURCE = "analytical_procedure_source";
	public static final String ANALYTICAL_PROCEDURE_ID = "analytical_procedure_id";
	public static final String CITATION_METHOD_NUM = "citation_method_num";
	public static final String METHOD_ID = "method_id";
	public static final String WQP_SOURCE = "wqp_source";
	public static final String METHOD_TYPE = "method_type";
	
	public WqpNemiNwisCrosswalk mapRow(ResultSet rs, int rowNum) throws SQLException {
		WqpNemiNwisCrosswalk wqpNemiNwisCrosswalk = new WqpNemiNwisCrosswalk();
		
		wqpNemiNwisCrosswalk.setAnalyticalProcedureSource(rs.getString(ANALYTICAL_PROCEDURE_SOURCE));
		wqpNemiNwisCrosswalk.setAnalyticalProcedureId(rs.getString(ANALYTICAL_PROCEDURE_ID));
		wqpNemiNwisCrosswalk.setCitationMethodNum(rs.getString(CITATION_METHOD_NUM));
		wqpNemiNwisCrosswalk.setMethodId(rs.getLong(METHOD_ID));
		wqpNemiNwisCrosswalk.setWqpSource(rs.getString(WQP_SOURCE));
		wqpNemiNwisCrosswalk.setMethodType(rs.getString(METHOD_TYPE));
		
		return wqpNemiNwisCrosswalk;
	}

}

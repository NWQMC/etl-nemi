package gov.acwi.wqp.etl.wqpNemiNwisCrosswalk;

import org.springframework.batch.item.ItemProcessor;

public class WqpNemiNwisCrosswalkProcessor implements ItemProcessor<WqpNemiNwisCrosswalk, WqpNemiNwisCrosswalk> {

	@Override
	public WqpNemiNwisCrosswalk process(WqpNemiNwisCrosswalk source) throws Exception {
		WqpNemiNwisCrosswalk result = new WqpNemiNwisCrosswalk();
		String nemiUrl = null;
		long methodId = source.getMethodId();
		String methodType = source.getMethodType();
		
		result.setAnalyticalProcedureSource(source.getAnalyticalProcedureSource());
		result.setAnalyticalProcedureId(source.getAnalyticalProcedureId());
		result.setCitationMethodNum(source.getCitationMethodNum());
		result.setMethodId(methodId);
		result.setWqpSource(source.getWqpSource());
		result.setMethodType(methodType);
		
		switch (methodType) {
			case "analytical" :
				nemiUrl = "https://www.nemi.gov/methods/method_summary/" + methodId + "/";
				break;
				
			case "statistical" :
				nemiUrl = "https://www.nemi.gov/methods/sams_method_summary/" + methodId + "/";
				break;
		}
		result.setNemiUrl(nemiUrl);
		
		return result;
	}
}

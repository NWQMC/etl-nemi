package gov.acwi.wqp.etl.wqpNemiNwisCrosswalk;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import gov.acwi.wqp.etl.wqpNemiNwisCrosswalk.WqpNemiNwisCrosswalk;
import gov.acwi.wqp.etl.wqpNemiNwisCrosswalk.WqpNemiNwisCrosswalkProcessor;

public class WqpNemiNwisCrosswalkProcessorTest {
	
	private WqpNemiNwisCrosswalkProcessor processor = new WqpNemiNwisCrosswalkProcessor();	
	
	@Test
	public void analyticalProcessorTest() throws Exception {
		WqpNemiNwisCrosswalk source = new WqpNemiNwisCrosswalk();
		WqpNemiNwisCrosswalk result = null;
		
		source.setAnalyticalProcedureSource("A Source");
		source.setAnalyticalProcedureId("A procedure id");
		source.setCitationMethodNum("citation-123");
		source.setMethodId(15678);
		source.setWqpSource("nwis");
		source.setMethodType("analytical");;
		
		result = processor.process(source);
		
		assertEquals(result.getAnalyticalProcedureSource(), "A Source");
		assertEquals(result.getAnalyticalProcedureId(), "A procedure id");
		assertEquals(result.getCitationMethodNum(), "citation-123");
		assertEquals(result.getMethodId(), 15678);
		assertEquals(result.getWqpSource(), "nwis");
		assertEquals(result.getMethodType(), "analytical");
		assertEquals(result.getNemiUrl(), "https://www.nemi.gov/methods/method_summary/15678/");		
	}
	
	@Test
	public void statisticalProcessorTest() throws Exception {
		WqpNemiNwisCrosswalk source = new WqpNemiNwisCrosswalk();
		WqpNemiNwisCrosswalk result = null;
		
		source.setAnalyticalProcedureSource("Another Source");
		source.setAnalyticalProcedureId("Another procedure id");
		source.setCitationMethodNum("citation-789");
		source.setMethodId(15000);
		source.setWqpSource("nwis");
		source.setMethodType("statistical");;
		
		result = processor.process(source);
		
		assertEquals(result.getAnalyticalProcedureSource(), "Another Source");
		assertEquals(result.getAnalyticalProcedureId(), "Another procedure id");
		assertEquals(result.getCitationMethodNum(), "citation-789");
		assertEquals(result.getMethodId(), 15000);
		assertEquals(result.getWqpSource(), "nwis");
		assertEquals(result.getMethodType(), "statistical");
		assertEquals(result.getNemiUrl(), "https://www.nemi.gov/methods/sams_method_summary/15000/");		
	}
	
	@Test
	public void unknownMethodTypeProcessorTest() throws Exception {
		WqpNemiNwisCrosswalk source = new WqpNemiNwisCrosswalk();
		WqpNemiNwisCrosswalk result = null;
		
		source.setAnalyticalProcedureSource("Another Source");
		source.setAnalyticalProcedureId("Another procedure id");
		source.setCitationMethodNum("citation-789");
		source.setMethodId(15000);
		source.setWqpSource("nwis");
		source.setMethodType("unknown");;
		
		result = processor.process(source);
		
		assertEquals(result.getAnalyticalProcedureSource(), "Another Source");
		assertEquals(result.getAnalyticalProcedureId(), "Another procedure id");
		assertEquals(result.getCitationMethodNum(), "citation-789");
		assertEquals(result.getMethodId(), 15000);
		assertEquals(result.getWqpSource(), "nwis");
		assertEquals(result.getMethodType(), "unknown");
		assertEquals(result.getNemiUrl(), null);		
	}
	

}

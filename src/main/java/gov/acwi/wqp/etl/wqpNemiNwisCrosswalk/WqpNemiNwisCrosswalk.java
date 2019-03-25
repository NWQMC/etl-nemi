package gov.acwi.wqp.etl.wqpNemiNwisCrosswalk;

public class WqpNemiNwisCrosswalk {
	private String analyticalProcedureSource;
	private String analyticalProcedureId;
	private String citationMethodNum;
	private long methodId;
	private String wqpSource;
	private String methodType;
	private String nemiUrl;
	
	public String getAnalyticalProcedureSource() {
		return analyticalProcedureSource;
	}

	public void setAnalyticalProcedureSource(String analyticalProcedureSource) {
		this.analyticalProcedureSource = analyticalProcedureSource;
	}

	public String getAnalyticalProcedureId() {
		return analyticalProcedureId;
	}

	public void setAnalyticalProcedureId(String analyticalProcedureId) {
		this.analyticalProcedureId = analyticalProcedureId;
	}

	public String getCitationMethodNum() {
		return citationMethodNum;
	}

	public void setCitationMethodNum(String citationMethodNum) {
		this.citationMethodNum = citationMethodNum;
	}

	public long getMethodId() {
		return methodId;
	}

	public void setMethodId(long methodId) {
		this.methodId = methodId;
	}

	public String getWqpSource() {
		return wqpSource;
	}

	public void setWqpSource(String wqpSource) {
		this.wqpSource = wqpSource;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getNemiUrl() {
		return nemiUrl;
	}

	public void setNemiUrl(String nemiUrl) {
		this.nemiUrl = nemiUrl;
	}
}

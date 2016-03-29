package cn.wuwenyao.blog.site.controller.dto.rep;

public class RepBaseDTO {

	private ResultCode code;
	private String mes;
	private RepData data;

	public ResultCode getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public RepData getData() {
		return data;
	}

	public void setData(RepData data) {
		this.data = data;
	}

}

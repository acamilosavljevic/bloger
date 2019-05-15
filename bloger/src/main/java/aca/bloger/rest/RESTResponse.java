package aca.bloger.rest;

import javax.xml.bind.annotation.XmlRootElement;

import aca.bloger.service.ErrorMessages;

@XmlRootElement
public class RESTResponse {

	private int code;
	
	private String errorMesage;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMesage() {
		return errorMesage;
	}

	public void setErrorMesage(String errorMesage) {
		this.errorMesage = errorMesage;
	}
	
	public void setErrorCode(ErrorMessages em) {
		
		this.code = em.getCode();
		this.errorMesage = em.getMessage();
	}
	
}

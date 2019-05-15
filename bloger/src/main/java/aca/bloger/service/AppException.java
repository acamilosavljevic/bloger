package aca.bloger.service;

import javax.ejb.ApplicationException;


@ApplicationException(rollback = true)
public class AppException extends RuntimeException{
	//default serial Id
	private static final long serialVersionUID = 1L;
	
	private ErrorMessages error;

	public AppException(ErrorMessages error) {
		this.error = error;
	}

	public ErrorMessages getError() {
		return error;
	}

	public void setError(ErrorMessages error) {
		this.error = error;
	}
	
	
	
	

}

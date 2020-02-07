package com.in28minutes.springboot.model;

public class ErrorMessage {

	String errorCode;
	String errorMessage;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(String errorCode, 
			String errorMessage) {
		//super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}

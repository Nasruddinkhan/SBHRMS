 /**
 * 
 */
 package com.mypractice.hrms.bean;

/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 1:40:03 am
 * ResponseMessage.java
 */
public class ResponseMessage {
	private Integer errorCode;
	private String errorMessage;
	private String token;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}

 

 /**
 * 
 */
 package com.mypractice.hrms.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 1:48:29 am
 * ErrorProperty.java
 */
 @Component
 @Configuration
 @PropertySource("classpath:errormessage.properties")
 public class ErrorProperty {
	 @Value("${success.cd}")
	 private Integer successCode;
	 @Value("${success.msg}")
	 private String successMsg;
	 @Value("${error.cd}")
	 private Integer errorCode;
	 @Value("${error.msg}")
	 private String errorMsg;
	public Integer getSuccessCode() {
		return successCode;
	}
	public void setSuccessCode(Integer successCode) {
		this.successCode = successCode;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}



}

 

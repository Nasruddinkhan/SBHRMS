 /**
 * 
 */
 package com.mypractice.hrms.bean;

import java.util.HashMap;
import java.util.Map;

import com.mypractice.hrms.model.User;

/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 1:40:03 am
 * ResponseMessage.java
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public class ResponseMessage {
	private Integer errorCode;
	private String errorMessage;
	private String token;
	private User user;
	private Map map = new HashMap();
	
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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

 

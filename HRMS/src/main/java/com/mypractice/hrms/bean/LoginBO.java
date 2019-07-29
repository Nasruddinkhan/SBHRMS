 /**
 * 
 */
 package com.mypractice.hrms.bean;

import java.io.Serializable;

/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:20:19 am
 * LoginBO.java
 */
public class LoginBO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8703690727018476694L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

 

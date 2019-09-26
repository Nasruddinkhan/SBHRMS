 /**
 * 
 */
 package com.mypractice.hrms.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 11:56:29 pm
 * MailProperty.java
 */
 @Configuration
 @PropertySource("classpath:mail.properties")
public class MailProperty {
	 public static final String TEMPLATES="templates";
	 public static final String SLASH="/";
	 public static final String TEST_EMAILTEMPLATE = "testmail";
	 public static final String VM = ".vm";
	 @Value("${mail.smtp.hostkey}")
	 private String hostKey;
	 @Value("${mail.smtp.hostValue}")
	 private String hostValue;
	 private String logStatus;
	 @Value("${mail.smtp.auth}")
	 private String auth;
	 @Value("${mail.smtp.username}")
	 private String userName;
	 @Value("${mail.smtp.password}")
	 private String password;
	 
	public String getHostKey() {
		return hostKey;
	}
	public void setHostKey(String hostKey) {
		this.hostKey = hostKey;
	}
	public String getHostValue() {
		return hostValue;
	}
	public void setHostValue(String hostValue) {
		this.hostValue = hostValue;
	}
	public String getLogStatus() {
		return logStatus;
	}
	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

 

 /**
 * 
 */
 package com.mypractice.hrms.bean;

import java.io.File;

import org.springframework.stereotype.Component;

/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 11:53:42 pm
 * MailModel.java
 */
@Component
public class MailModel {
	private String fromMail;
	private String toMail;
	private String ccMail;
	private Object obj;
	private String subject;
	private String template;
	private File[] attachment;
	/**
	 * @return the fromMail
	 */
	public String getFromMail() {
		return fromMail;
	}
	/**
	 * @param fromMail the fromMail to set
	 */
	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}
	/**
	 * @return the toMail
	 */
	public String getToMail() {
		return toMail;
	}
	/**
	 * @param toMail the toMail to set
	 */
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	/**
	 * @return the ccMail
	 */
	public String getCcMail() {
		return ccMail;
	}
	/**
	 * @param ccMail the ccMail to set
	 */
	public void setCcMail(String ccMail) {
		this.ccMail = ccMail;
	}
	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}
	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	/**
	 * @return the attachment
	 */
	public File[] getAttachment() {
		return attachment;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(File[] attachment) {
		this.attachment = attachment;
	}

}

 

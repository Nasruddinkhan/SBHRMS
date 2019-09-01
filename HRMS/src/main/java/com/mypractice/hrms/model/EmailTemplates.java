 /**
 * 
 */
 package com.mypractice.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mypractice.hrms.util.CommonUtils;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:21:44 pm
 * EmailTemplates.java
 */
 @Entity
 @Table(name = "HRMS_EMAIL_TEMPLATES")
 public class EmailTemplates extends BaseBean implements Serializable{
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = -5771314187877255607L;
 	@Id
 	@Column(name = "TEMPLATE_ID")
 	private Integer templateID;
 	@Column(name = "TEMPLATE_NAME", columnDefinition = CommonUtils.VARCHAR_50)
 	private String 	templateName;
 	@Column(name = "FROM_ID", columnDefinition = CommonUtils.VARCHAR_50)
 	private String fromID;
 	@Column(name = "subjects", columnDefinition = CommonUtils.VARCHAR_50)
 	private String subjects;
 	public Integer getTemplateID() {
 		return templateID;
 	}
 	public String getTemplateName() {
 		return templateName;
 	}
 	public String getFromID() {
 		return fromID;
 	}
 	public String getSubjects() {
 		return subjects;
 	}
 	
 	public void setTemplateID(Integer templateID) {
 		this.templateID = templateID;
 	}
 	public void setTemplateName(String templateName) {
 		this.templateName = templateName;
 	}
 	public void setFromID(String fromID) {
 		this.fromID = fromID;
 	}
 	public void setSubjects(String subjects) {
 		this.subjects = subjects;
 	}
 	
 	@Override
 	public String toString() {
 		return "EmailTemplates [templateID=" + templateID + ", templateName=" + templateName + ", fromID=" + fromID
 				+ ", subjects=" + subjects + "]";
 	}
 	
 	
 }


 

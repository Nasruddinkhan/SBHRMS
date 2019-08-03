 /**
 * 
 */
 package com.mypractice.hrms.repository;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Nasruddin Khan 
 * 03-Aug-2019 - 9:51:58 pm
 * SkillElelentsDetails.java
 */
public interface SkillElelentsDetails {
	public Integer getSkillElementID();
	public String  getSkillElementName() ;
	public Integer getSkillID();
	public Integer getOrderlevl() ;
	public String getSkillName();
	public LocalDateTime getCreatedDate() ;
	public String getCreatedBy();
	public Date getModifiedDate();
	public String getModifiedBy();
	public Integer getActiveStatus();
}

 

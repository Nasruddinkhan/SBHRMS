 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.time.LocalDateTime;

/**
 * @author Nasruddin Khan 
 * 11-Sep-2019 - 1:48:50 am
 * SubMenuDetails.java
 */
public interface SubMenuDetails {
	public String getSubMenuId();
	public String getSubMenuName();
	public String getMenuName();
	public String getCreatedBy(); 
	public Integer getActiveStatus();
	public LocalDateTime getCreatedDate();
	public String getRoleName();
}

 

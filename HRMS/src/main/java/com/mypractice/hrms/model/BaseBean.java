package com.mypractice.hrms.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.mypractice.hrms.util.CommonUtils;

/**
 * Nasruddin khan
 * BaseBean.java
 * Apr 17, 2019 7:17:31 PM
 */
@MappedSuperclass
public class BaseBean {
	@Column(name ="CREATED_ON")	
	@CreationTimestamp
	private LocalDateTime createdDate;
	@Column(name ="CREATED_BY" ,columnDefinition=CommonUtils.VARCHAR_50)	
	private String createdBy;
	@Column(name ="LAST_UPDATED_ON")	
	private Date modifiedDate;
	@Column(name ="LAST_UPDATED_BY" ,columnDefinition=CommonUtils.VARCHAR_50)	
	private String modifiedBy;
	@Column(name ="ACTIVE_STATUS", columnDefinition=CommonUtils.DEFAULT)	 
	private Integer activeStatus;
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Integer getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}
}

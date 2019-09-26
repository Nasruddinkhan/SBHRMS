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
 * 31-Aug-2019 - 12:42:06 pm
 * StatusMaster.java
 */
@Entity
@Table(name = "STATUS_MASTER" )
public final class StatusMaster extends BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2957652468565457357L;
	@Id
	@Column(name = "STATUS_ID", columnDefinition = CommonUtils.CHAR_3)
	private String statusID;
	@Column(name = "STATUS_NAME", columnDefinition = CommonUtils.VARCHAR_50)
	private String statusName;
	public String getStatusID() {
		return statusID;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusID(String statusID) {
		this.statusID = statusID;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "StatusMaster [statusID=" + statusID + ", statusName=" + statusName + "]";
	}
	
}

 

/**
 * nasru
 * WorkStataus.java
 * Mar 10, 2020
 */
package com.mypractice.hrms.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nasru
 *
 */
@Entity
@Table(name = "WORK_REMARKS")
public class WorkStataus implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 274713964323820368L;
	@Id
	@Column(name = "WORK_STATUS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_status_master")
	@SequenceGenerator(name = "work_status_master", sequenceName = "work_status_seq", allocationSize = 1, initialValue = 5000)
	private Integer workStatusID;
	@Column(name = "WORK_DATE")
	private Date workDate;
	@Column(name = "START_TIME")
	private Timestamp startTime;
	@Column(name = "END_TIME")
	private Timestamp endTime;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_WORKSTATAUS_ID"))
	@JsonIgnore
	private User user;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKILL_ID", foreignKey = @ForeignKey(name = "FK_WORKSTATAUS_SKILL_ID"))
	@JsonIgnore
	private SkillMaster skillMst;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKILL_ELEMENT_ID", foreignKey = @ForeignKey(name = "FK_WORKSTATAUS_SKILL_ELEMENT_ID"))
	@JsonIgnore
	private SkillElementMaster skillElementMst;
	@Column(name = "REMARKS", length = 800)
	private String remarks;
	/**
	 * @return the workStatusID
	 */
	public Integer getWorkStatusID() {
		return workStatusID;
	}
	/**
	 * @return the workDate
	 */
	public Date getWorkDate() {
		return workDate;
	}
	/**
	 * @return the startTime
	 */
	public Timestamp getStartTime() {
		return startTime;
	}
	/**
	 * @return the endTime
	 */
	public Timestamp getEndTime() {
		return endTime;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the skillMst
	 */
	public SkillMaster getSkillMst() {
		return skillMst;
	}
	/**
	 * @return the skillElementMst
	 */
	public SkillElementMaster getSkillElementMst() {
		return skillElementMst;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param workStatusID the workStatusID to set
	 */
	public void setWorkStatusID(Integer workStatusID) {
		this.workStatusID = workStatusID;
	}
	/**
	 * @param workDate the workDate to set
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param skillMst the skillMst to set
	 */
	public void setSkillMst(SkillMaster skillMst) {
		this.skillMst = skillMst;
	}
	/**
	 * @param skillElementMst the skillElementMst to set
	 */
	public void setSkillElementMst(SkillElementMaster skillElementMst) {
		this.skillElementMst = skillElementMst;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "WorkStataus [workStatusID=" + workStatusID + ", workDate=" + workDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", user=" + user + ", skillMst=" + skillMst + ", skillElementMst="
				+ skillElementMst + ", remarks=" + remarks + "]";
	}
	
}

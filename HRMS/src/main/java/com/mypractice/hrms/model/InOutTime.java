/**
 * nasru
 * InOutTime.java
 * Feb 8, 2020
 */
package com.mypractice.hrms.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
@Table(name="ATTENDENTS_DETAILS")
@Entity
public class InOutTime {
	@Column(name = "IN_OUT_TIMEID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inouttime_master")
	@SequenceGenerator(name="inouttime_master", sequenceName = "inout_seq", allocationSize=1,initialValue = 10000)
	private Integer inOutTimeID;
	@Column(name ="IN_TIME")	
	private LocalDateTime inTime;
	@Column(name ="OUT_TIME")	
	private LocalDateTime inOutTime;
	@Column(name ="DAY", length = 15)	
	private String day;
	@Column(name = "TOTAL_SPENT_HOURS")
	private LocalTime  totalSpendHours;
	@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name="FK_USERINOUTTIME_USER_ID"))
	@JsonIgnore
	private User user;
	/**
	 * @return the inOutTimeID
	 */
	public Integer getInOutTimeID() {
		return inOutTimeID;
	}
	/**
	 * @return the inTime
	 */
	public LocalDateTime getInTime() {
		return inTime;
	}
	/**
	 * @return the inOutTime
	 */
	public LocalDateTime getInOutTime() {
		return inOutTime;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @return the totalSpendHours
	 */
	public LocalTime  getTotalSpendHours() {
		return totalSpendHours;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param inOutTimeID the inOutTimeID to set
	 */
	public void setInOutTimeID(Integer inOutTimeID) {
		this.inOutTimeID = inOutTimeID;
	}
	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}
	/**
	 * @param inOutTime the inOutTime to set
	 */
	public void setInOutTime(LocalDateTime inOutTime) {
		this.inOutTime = inOutTime;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @param totalSpendHours the totalSpendHours to set
	 */
	public void setTotalSpendHours(LocalTime  totalSpendHours) {
		this.totalSpendHours = totalSpendHours;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "InOutTime [inOutTimeID=" + inOutTimeID + ", inTime=" + inTime + ", inOutTime=" + inOutTime + ", day="
				+ day + ", totalSpendHours=" + totalSpendHours + ", user=" + user + "]";
	}

}	

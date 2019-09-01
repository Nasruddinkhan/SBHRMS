package com.mypractice.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mypractice.hrms.util.CommonUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All state detals")
@Table(name="STATE_MASTER")
@Entity
public final class StateMaster extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_master")
	@SequenceGenerator(name="state_master", sequenceName = "state_master_seq", allocationSize=1,initialValue = 2000)
	@Column(name="STATE_ID",  nullable = false)
	private Integer stateID;
	@ApiModelProperty(notes="minimum 3 charecter is required")
	@Column(name="STATE_NAME", columnDefinition=CommonUtils.VARCHAR_50)
	private String stateName;
	@Column(name="UPD_COUNTER")
	@Version
	private Integer counter;
	
	public Integer getCounter() {
		return counter;
	}
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	public Integer getStateID() {
		return stateID;
	}
	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
}

package com.mypractice.hrms.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	@Column(name="COUNTRY_CODE", columnDefinition = CommonUtils.CHAR_3)
	private String countryCode;
	
	@OneToMany(mappedBy = "stateMst", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CityMaster> cityMasters ;
	
	public List<CityMaster> getCityMasters() {
		return cityMasters;
	}
	public void setCityMasters(List<CityMaster> cityMasters) {
		this.cityMasters = cityMasters;
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "StateMaster [stateID=" + stateID + ", stateName=" + stateName + ", countryCode=" + countryCode+ "]";
	}
	
}

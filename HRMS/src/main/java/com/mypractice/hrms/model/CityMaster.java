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

@ApiModel(description="All city detals")
@Table(name="CITY_MST")
@Entity
public class CityMaster extends BaseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_master")
	@SequenceGenerator(name="city_master", sequenceName = "city_master_seq", allocationSize=1,initialValue = 100)
	@Column(name="CITY_ID",  nullable = false)
	private Integer cityID;
	
	@ApiModelProperty(notes="minimum 3 charecter is required")
	@Column(name="CITY_NAME", columnDefinition=CommonUtils.VARCHAR_50)
	private String cityName;
	
	@Column(name="STATE_ID")
	private Integer stateID;
	
	@Column(name="UPD_COUNTER")
	@Version
	private Integer counter;

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "CityMaster [cityID=" + cityID + ", cityName=" + cityName + ", stateID=" + stateID + ", counter="
				+ counter + "]";
	}
}

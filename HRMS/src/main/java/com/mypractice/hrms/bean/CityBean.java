 /**
 * 
 */
 package com.mypractice.hrms.bean;
 /**
 * @author Nasruddin Khan 
 * 13-Oct-2019 - 6:02:19 pm
 * CityBean.java
 */
 public class CityBean {
	 private Integer cityID;
	 private String cityName;
	 private String stateName;
	 private String cratedBy;
	 
	public CityBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityBean(Integer cityID, String cityName, String stateName, String cratedBy) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
		this.stateName = stateName;
		this.cratedBy = cratedBy;
	}
	public Integer getCityID() {
		return cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public String getCratedBy() {
		return cratedBy;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public void setCratedBy(String cratedBy) {
		this.cratedBy = cratedBy;
	}
	 
}

 

/**
 * nasru
 * ApplicationBean.java
 * Jan 17, 2020
 */
package com.mypractice.hrms.bean;

/**
 * @author nasru
 *
 */
public class ApplicationBean {
	private String course;
	private String collegeName;
	private String univercityName;
	private String duration;
	private String percentage;
	
	/**
	 * 
	 */
	public ApplicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param course
	 * @param collegeName
	 * @param univercityName
	 * @param duration
	 * @param percentage
	 */
	public ApplicationBean(String course, String collegeName, String univercityName, String duration,
			String percentage) {
		super();
		this.course = course;
		this.collegeName = collegeName;
		this.univercityName = univercityName;
		this.duration = duration;
		this.percentage = percentage;
	}
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * @return the univercityName
	 */
	public String getUnivercityName() {
		return univercityName;
	}
	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	/**
	 * @param univercityName the univercityName to set
	 */
	public void setUnivercityName(String univercityName) {
		this.univercityName = univercityName;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

}

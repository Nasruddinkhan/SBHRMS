/**
 * nasru
 * EducationBean.java
 * Jan 1, 2020
 */
package com.mypractice.hrms.bean;

import com.mypractice.hrms.model.Course;
import com.mypractice.hrms.model.Univercity;
import com.mypractice.hrms.model.User;

/**
 * @author nasru
 *
 */
public class EducationBean {
	private Integer educationID;
	private String fromDate;
	private String toDate;
	private String collegeName;
	private String courseID;
	private String courseName;
	private String universityID;
	private String univercityName;
	private String comments;
	/**
	 * @return the educationID
	 */
	public Integer getEducationID() {
		return educationID;
	}
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}
	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @return the universityID
	 */
	public String getUniversityID() {
		return universityID;
	}
	/**
	 * @return the univercityName
	 */
	public String getUnivercityName() {
		return univercityName;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param educationID the educationID to set
	 */
	public void setEducationID(Integer educationID) {
		this.educationID = educationID;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @param universityID the universityID to set
	 */
	public void setUniversityID(String universityID) {
		this.universityID = universityID;
	}
	/**
	 * @param univercityName the univercityName to set
	 */
	public void setUnivercityName(String univercityName) {
		this.univercityName = univercityName;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}

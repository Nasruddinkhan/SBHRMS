/**
 * nasru
 * Course.java
 * Dec 29, 2019
 */
package com.mypractice.hrms.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author nasru
 *
 */
@Table(name = "COURSE_DETAILS")
@Entity
public class Course extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "COURSE_ID", length = 10)
	private String courseID;
	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;
	@OneToMany(mappedBy = "educationMst", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Education> education ;
	
	/**
	 * @return the education
	 */
	public List<Education> getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(List<Education> education) {
		this.education = education;
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

}

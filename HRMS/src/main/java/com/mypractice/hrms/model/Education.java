/**
 * nasru
 * Education.java
 * Dec 29, 2019
 */
package com.mypractice.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author nasru
 *
 */
@Entity
@Table(name = "EDUCATION_DETAILS")
public class Education extends BaseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 884173470484149757L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_master")
	@SequenceGenerator(name="education_master", sequenceName = "education_master_seq", allocationSize=1,initialValue = 100)
	@Column(name="EDUCATION_ID",  nullable = false)
	private Integer educationID;
	@Column(name = "FROM_DATE", length = 10)
	private String fromDate;
	@Column(name = "TO_DATE", length = 10)
	private String toDate;
	@Column(name = "COLLEGE_NAME", length = 100)
	private String collegeName;
	@Column(name = "PERCENTAGE")
	private Double percentage;
	
	@OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name="FK_EDUCATION_USER_ID"))
	@JsonIgnore
    private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COURSE_ID" , foreignKey = @ForeignKey(name="FK_COURSE_ID_COURSE"))
	@JsonIgnore
	private Course educationMst;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIVERSITY_ID" , foreignKey = @ForeignKey(name="FK_UNIVERSITY_ID_UNIVERSITY"))
	@JsonIgnore
	private Univercity universityMst;
	@Column(name = "COMMENTS", length = 200)
	private String comments;
	
	/**
	 * @return the percentage
	 */
	public Double getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the educationMst
	 */
	public Course getEducationMst() {
		return educationMst;
	}
	/**
	 * @return the universityMst
	 */
	public Univercity getUniversityMst() {
		return universityMst;
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
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param educationMst the educationMst to set
	 */
	public void setEducationMst(Course educationMst) {
		this.educationMst = educationMst;
	}
	/**
	 * @param universityMst the universityMst to set
	 */
	public void setUniversityMst(Univercity universityMst) {
		this.universityMst = universityMst;
	}
	
	
}

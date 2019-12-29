/**
 * nasru
 * Univercity.java
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
@Table(name = "UNIVERSITY_DETAILS")
@Entity
public class Univercity extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "UNIVERSITY_ID", length = 10)
	private String universityID;
	@Column(name = "UNIVERSITY_NAME", length = 50)
	private String univercityName;
	@OneToMany(mappedBy = "universityMst", fetch = FetchType.LAZY)
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
	 * @return the universityID
	 */
	public String getUniversityID() {
		return universityID;
	}

	/**
	 * @param universityID the universityID to set
	 */
	public void setUniversityID(String universityID) {
		this.universityID = universityID;
	}

	/**
	 * @return the univercityName
	 */
	public String getUnivercityName() {
		return univercityName;
	}
	
	/**
	 * @param univercityName the univercityName to set
	 */
	public void setUnivercityName(String univercityName) {
		this.univercityName = univercityName;
	}
	
}

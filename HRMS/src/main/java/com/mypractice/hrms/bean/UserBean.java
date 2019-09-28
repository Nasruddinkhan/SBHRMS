 /**
 * 
 */
 package com.mypractice.hrms.bean;

import java.sql.Date;

/**
 * @author Nasruddin Khan 
 * 29-Sep-2019 - 1:18:22 am
 * UserBean.java
 */
public class UserBean {
	private String firstName;
	private String lastName;
	private String fatherName;
	private String gender;
	private Date dob;
	private String maritial;
	private Date doj;
	private String email;
	private String contactno;
	private String guardian;
	private String aadhaarno;
	private String  pancard;
	private String isPersonalFlag;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public String getGender() {
		return gender;
	}
	public Date getDob() {
		return dob;
	}
	public String getMaritial() {
		return maritial;
	}
	public Date getDoj() {
		return doj;
	}
	public String getEmail() {
		return email;
	}
	public String getContactno() {
		return contactno;
	}
	public String getGuardian() {
		return guardian;
	}
	public String getAadhaarno() {
		return aadhaarno;
	}
	public String getPancard() {
		return pancard;
	}
	public String getIsPersonalFlag() {
		return isPersonalFlag;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setMaritial(String maritial) {
		this.maritial = maritial;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
	public void setAadhaarno(String aadhaarno) {
		this.aadhaarno = aadhaarno;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public void setIsPersonalFlag(String isPersonalFlag) {
		this.isPersonalFlag = isPersonalFlag;
	}
}

 

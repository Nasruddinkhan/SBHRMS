 /**
 * 
 */
 package com.mypractice.hrms.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mypractice.hrms.util.CommonUtils;

import io.swagger.annotations.ApiModel;

/**
 * @author Nasruddin Khan 
 * 24-Aug-2019 - 9:20:36 pm
 * User.java
 */
@Entity
@Table(name = "USERS")
@ApiModel(description = "All users details")
public final class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6166329038041154147L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_master")
	@SequenceGenerator(name="user_master", sequenceName = "user_seq", allocationSize=1,initialValue = 50)
	private Integer userID;

	
	@OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "STATUS_ID", foreignKey = @ForeignKey(name="FK_STATUS_ID"))
    private StatusMaster statusMaster;
	

	@OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "ROLE_ID", foreignKey = @ForeignKey(name="FK_USER_ROLE_ID"))
    private UserRole userRole;
	
	@Column(name = "FIRST_NAME", columnDefinition = CommonUtils.VARCHAR_50)
	private String firstName;

	@Column(name = "LAST_NAME", columnDefinition = CommonUtils.VARCHAR_30)
	private String lastName;

	@Column(name = "FATHER_NAME", columnDefinition = CommonUtils.VARCHAR_50)
	private String fatherName;

	@Column(name = "GENDER", columnDefinition = CommonUtils.CHAR_01)
	private String gender;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "MARITIAL_STATUS", columnDefinition = CommonUtils.CHAR_01)
	private String maritialStatus;

	@Column(name = "DOJ")
	private Date doj;

	@Column(name = "EMAIL", columnDefinition = CommonUtils.VARCHAR_50)
	private String email;

	@Column(name = "CONTACT_NO",  columnDefinition = CommonUtils.VARCHAR_15)
	private String contactNo;

	@Column(name = "GURDIAN_CONTACT_NO",  columnDefinition = CommonUtils.VARCHAR_15)
	private String gurdianContactNo;

	@Column(name = "AADHAAR_NO",  columnDefinition = CommonUtils.VARCHAR_12)
	private String aadhaarDetails;

	@Column(name = "PAN_CARD",  columnDefinition = CommonUtils.VARCHAR_15)
	private String panCard;

	//@JsonIgnore
	@Column(name = "PASSWORD", columnDefinition = CommonUtils.VARCHAR_20 )
	private String password;

	@JsonIgnoreProperties
	@Transient
	private String confPassword;
	
	@Column(name = "USER_TYPE",  columnDefinition = CommonUtils.VARCHAR_15)
	private String userType;

	@Column(name = "IS_PERSONAL_FLAG", columnDefinition = CommonUtils.CHAR_01_DFLT)
	private String isPersonalFlag;
	@Column(name = "REFERER_NAME" , length = 30)
	private String refererName;
	@Column(name = "REFERER_EMAIL" , length = 50)
	private String refererEmail;
	@Column(name = "REFERER_CONTACT" , length = 15)
	private String refererContact;
	
	/**
	 * @param userID
	 * @param statusMaster
	 * @param userRole
	 * @param firstName
	 * @param lastName
	 * @param fatherName
	 * @param gender
	 * @param dob
	 * @param maritialStatus
	 * @param doj
	 * @param email
	 * @param contactNo
	 * @param gurdianContactNo
	 * @param aadhaarDetails
	 * @param panCard
	 * @param password
	 * @param confPassword
	 * @param userType
	 * @param isPersonalFlag
	 * @param refererName
	 * @param refererEmail
	 * @param refererContact
	 */
	public User(Integer userID, StatusMaster statusMaster, UserRole userRole, String firstName, String lastName,
			String fatherName, String gender, Date dob, String maritialStatus, Date doj, String email, String contactNo,
			String gurdianContactNo, String aadhaarDetails, String panCard, String password, String confPassword,
			String userType, String isPersonalFlag, String refererName, String refererEmail, String refererContact) {
		super();
		this.userID = userID;
		this.statusMaster = statusMaster;
		this.userRole = userRole;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.gender = gender;
		this.dob = dob;
		this.maritialStatus = maritialStatus;
		this.doj = doj;
		this.email = email;
		this.contactNo = contactNo;
		this.gurdianContactNo = gurdianContactNo;
		this.aadhaarDetails = aadhaarDetails;
		this.panCard = panCard;
		this.password = password;
		this.confPassword = confPassword;
		this.userType = userType;
		this.isPersonalFlag = isPersonalFlag;
		this.refererName = refererName;
		this.refererEmail = refererEmail;
		this.refererContact = refererContact;
	}
	
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIsPersonalFlag() {
		return isPersonalFlag;
	}
	public void setIsPersonalFlag(String isPersonalFlag) {
		this.isPersonalFlag = isPersonalFlag;
	}
	
	/**
	 * @return the refererName
	 */
	public String getRefererName() {
		return refererName;
	}
	/**
	 * @return the refererEmail
	 */
	public String getRefererEmail() {
		return refererEmail;
	}
	/**
	 * @return the refererContact
	 */
	public String getRefererContact() {
		return refererContact;
	}
	/**
	 * @param refererName the refererName to set
	 */
	public void setRefererName(String refererName) {
		this.refererName = refererName;
	}
	/**
	 * @param refererEmail the refererEmail to set
	 */
	public void setRefererEmail(String refererEmail) {
		this.refererEmail = refererEmail;
	}
	/**
	 * @param refererContact the refererContact to set
	 */
	public void setRefererContact(String refererContact) {
		this.refererContact = refererContact;
	}
	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public StatusMaster getStatusMaster() {
		return statusMaster;
	}
	public void setStatusMaster(StatusMaster statusMaster) {
		this.statusMaster = statusMaster;
	}
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
	public String getMaritialStatus() {
		return maritialStatus;
	}
	public Date getDoj() {
		return doj;
	}
	public String getEmail() {
		return email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public String getGurdianContactNo() {
		return gurdianContactNo;
	}
	public String getAadhaarDetails() {
		return aadhaarDetails;
	}
	public String getPanCard() {
		return panCard;
	}
	public String getPassword() {
		return password;
	}
	public String getConfPassword() {
		return confPassword;
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
	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public void setGurdianContactNo(String gurdianContactNo) {
		this.gurdianContactNo = gurdianContactNo;
	}
	public void setAadhaarDetails(String aadhaarDetails) {
		this.aadhaarDetails = aadhaarDetails;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", statusMaster=" + statusMaster + ", userRole=" + userRole + ", firstName="
				+ firstName + ", lastName=" + lastName + ", fatherName=" + fatherName + ", gender=" + gender + ", dob="
				+ dob + ", maritialStatus=" + maritialStatus + ", doj=" + doj + ", email=" + email + ", contactNo="
				+ contactNo + ", gurdianContactNo=" + gurdianContactNo + ", aadhaarDetails=" + aadhaarDetails
				+ ", panCard=" + panCard + ", password=" + password + ", confPassword=" + confPassword + ", userType="
				+ userType + ", isPersonalFlag=" + isPersonalFlag + ", refererName=" + refererName + ", refererEmail="
				+ refererEmail + ", refererContact=" + refererContact + "]";
	}

}

 

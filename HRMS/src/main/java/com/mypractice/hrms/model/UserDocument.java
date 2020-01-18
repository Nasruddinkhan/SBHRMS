/**
 * nasru
 * UserDocument.java
 * Jan 4, 2020
 */
package com.mypractice.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "USER_DOCUMENTS")
public class UserDocument  extends BaseBean{
	@Id
	@Column(name = "USER_DOC_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mydoc_master")
	@SequenceGenerator(name="mydoc_master", sequenceName = "mydoc_seq", allocationSize=1,initialValue = 50)
	private Integer userDocID;
	@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name="FK_USERDOCUMENT_USER_ID"))
	@JsonIgnore
	private User user;
	@Column(name = "DOC_LOCATION", length = 50)
	private String document;
	@Column(name = "DOC_CONTENT", length = 10)
	private String doccumentContentType;
	@Column(name = "DOCUMENT_NAME", length = 50 )
	private String docuentName;
	/*
	 * @Column(name = "DOCUENT_TYPE", length = 50 ) private String docuentType;
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCUMENT_ID" , foreignKey = @ForeignKey(name="FK_DOC_ID_DOCUMENT"))
	@JsonIgnore
	private DocumentMaster usrDocuments;
	
	/**
	 * @return the doccumentContentType
	 */
	public String getDoccumentContentType() {
		return doccumentContentType;
	}
	/**
	 * @param doccumentContentType the doccumentContentType to set
	 */
	public void setDoccumentContentType(String doccumentContentType) {
		this.doccumentContentType = doccumentContentType;
	}
	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}
	/**
	 * @return the usrDocuments
	 */
	public DocumentMaster getUsrDocuments() {
		return usrDocuments;
	}
	/**
	 * @param usrDocuments the usrDocuments to set
	 */
	public void setUsrDocuments(DocumentMaster usrDocuments) {
		this.usrDocuments = usrDocuments;
	}
	/**
	 * @return the userDocID
	 */
	public Integer getUserDocID() {
		return userDocID;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the docuentName
	 */
	public String getDocuentName() {
		return docuentName;
	}
	/**
	 * @return the docuentType
	 
	public String getDocuentType() {
		return docuentType;
	}*/
	/**
	 * @param userDocID the userDocID to set
	 */
	public void setUserDocID(Integer userDocID) {
		this.userDocID = userDocID;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param docuentName the docuentName to set
	 */
	public void setDocuentName(String docuentName) {
		this.docuentName = docuentName;
	}
	
	/**
	 * @param docuentType the docuentType to set
	
	public void setDocuentType(String docuentType) {
		this.docuentType = docuentType;
	} */
}

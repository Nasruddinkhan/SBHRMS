/**
 * nasru
 * DocumentMaster.java
 * Jan 4, 2020
 */
package com.mypractice.hrms.model;

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
 *
 */
@Entity
@Table(name = "DOCUMENT_MASTER")
public class DocumentMaster extends BaseBean {
	@Column(name = "DOCUMENT_ID", length = 10)
	@Id
	private String documentID;
	@Column(name = "DOCUMENT_NAME", length = 50)
	private String documentName;
	
	@OneToMany(mappedBy = "usrDocuments", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<UserDocument> usrDocuments ;

	/**
	 * @return the usrDocuments
	 */
	public List<UserDocument> getUsrDocuments() {
		return usrDocuments;
	}

	/**
	 * @param usrDocuments the usrDocuments to set
	 */
	public void setUsrDocuments(List<UserDocument> usrDocuments) {
		this.usrDocuments = usrDocuments;
	}

	/**
	 * @return the documentID
	 */
	public String getDocumentID() {
		return documentID;
	}

	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param documentID the documentID to set
	 */
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

}
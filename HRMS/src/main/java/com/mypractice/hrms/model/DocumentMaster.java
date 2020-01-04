/**
 * nasru
 * DocumentMaster.java
 * Jan 4, 2020
 */
package com.mypractice.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
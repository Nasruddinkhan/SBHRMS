/**
 * nasru
 * UserUploadDocBean.java
 * Jan 12, 2020
 */
package com.mypractice.hrms.bean;

/**
 * @author nasru
 *
 */
public class UserUploadDocBean {
private String file;
private String fileName;
private String documentID;
private String  contentType;
private String  eduDocs;
private Integer userId;
private Integer userDocID;
private String docID;

/**
 * @return the docID
 */
public String getDocID() {
	return docID;
}

/**
 * @param docID the docID to set
 */
public void setDocID(String docID) {
	this.docID = docID;
}

/**
 * @return the userDocID
 */
public Integer getUserDocID() {
	return userDocID;
}

/**
 * @param userDocID the userDocID to set
 */
public void setUserDocID(Integer userDocID) {
	this.userDocID = userDocID;
}

/**
 * @return the userId
 */
public Integer getUserId() {
	return userId;
}

/**
 * @param userId the userId to set
 */
public void setUserId(Integer userId) {
	this.userId = userId;
}

/**
 * @return the fileName
 */
public String getFileName() {
	return fileName;
}

/**
 * @return the documentID
 */
public String getDocumentID() {
	return documentID;
}

/**
 * @return the contentType
 */
public String getContentType() {
	return contentType;
}

/**
 * @return the eduDocs
 */
public String getEduDocs() {
	return eduDocs;
}

/**
 * @param fileName the fileName to set
 */
public void setFileName(String fileName) {
	this.fileName = fileName;
}

/**
 * @param documentID the documentID to set
 */
public void setDocumentID(String documentID) {
	this.documentID = documentID;
}

/**
 * @param contentType the contentType to set
 */
public void setContentType(String contentType) {
	this.contentType = contentType;
}

/**
 * @param eduDocs the eduDocs to set
 */
public void setEduDocs(String eduDocs) {
	this.eduDocs = eduDocs;
}

/**
 * @return the file
 */
public String getFile() {
	return file;
}

/**
 * @param file the file to set
 */
public void setFile(String file) {
	this.file = file;
}

@Override
public String toString() {
	return "UserUploadDocBean [file=" + file + ", fileName=" + fileName + ", documentID=" + documentID
			+ ", contentType=" + contentType + ", eduDocs=" + eduDocs + ", userId=" + userId + "]";
}

}

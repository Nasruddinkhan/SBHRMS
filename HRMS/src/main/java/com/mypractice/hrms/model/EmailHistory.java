 /**
 * 
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
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mypractice.hrms.util.CommonUtils;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:20:25 pm
 * EmailHistory.java
 */
@Entity
@Table(name="HRMS_EMAIL_DETAILS")
public final class EmailHistory extends BaseBean implements Serializable {
	private static final long serialVersionUID = -389969670561673732L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_history_master")
	@SequenceGenerator(name="email_history_master", sequenceName = "email_history_seq", allocationSize=1,initialValue = 1000)
	@Column(name="EMAI_HISTORY_ID")
	private Integer emailHistory;
	@OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "TEMPLATE_ID", foreignKey = @ForeignKey(name="FK_TEMPLATE__ID"))
    private EmailTemplates emailTemplates;
	
	@Column(name="EMAIL_TO", columnDefinition=CommonUtils.VARCHAR_500)
	private String emailTo;
	
	@Column(name="EMAIL_CC", columnDefinition=CommonUtils.VARCHAR_500)
	private String emailCc;
	
	@Column(name="IS_EMAIL_SENT", columnDefinition=CommonUtils.CHAR_01)
	private String isEmailSent;
	@Lob
	@Column(name = "EMAIL_OBJECT")
	private String emailObject;
	
	@Column(name = "APPROVER", columnDefinition = CommonUtils.VARCHAR_50 )
	private String approverName;
	
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public EmailTemplates getEmailTemplates() {
		return emailTemplates;
	}
	public void setEmailTemplates(EmailTemplates emailTemplates) {
		this.emailTemplates = emailTemplates;
	}


	public Integer getEmailHistory() {
		return emailHistory;
	}
	public void setEmailHistory(Integer emailHistory) {
		this.emailHistory = emailHistory;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public String getEmailCc() {
		return emailCc;
	}
	public String getIsEmailSent() {
		return isEmailSent;
	}
	public String getEmailObject() {
		return emailObject;
	}
	
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public void setEmailCc(String emailCc) {
		this.emailCc = emailCc;
	}
	public void setIsEmailSent(String isEmailSent) {
		this.isEmailSent = isEmailSent;
	}
	public void setEmailObject(String emailObject) {
		this.emailObject = emailObject;
	}
	
	public EmailHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmailHistory [emailHistory=" + emailHistory + ", emailTemplates=" + emailTemplates + ", emailTo="
				+ emailTo + ", emailCc=" + emailCc + ", isEmailSent=" + isEmailSent + ", emailObject=" + emailObject
				+ ", approverName=" + approverName + "]";
	}
	
}

 

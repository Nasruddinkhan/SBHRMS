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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mypractice.hrms.util.CommonUtils;

/**
 * @author Nasruddin Khan 
 * 25-Sep-2019 - 12:46:42 am
 * MenuAccessRole.java
 */
@Entity
@Table(name = "MENU_ACCESS")
public class MenuAccessRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6891067940537478961L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_access")
	@SequenceGenerator(name="menu_access", sequenceName = "menu_access_seq", allocationSize=1,initialValue = 4000)
	@Column(name="MENU_ACCESS_ID")
	private Integer menuAccessId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUB_MENU_ID" , foreignKey = @ForeignKey(name="FK_MENU_ACCESS_SUB_MENU_ID"))
	@JsonIgnore 
	private SubMenus menu;
	@OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name="FK_MENU_ACCESS_USER_ID"))
    private User user;
	
	@Column(name="ACCESS_START_DATE")
	private Date accessStartDate;
	@Column(name="ACCESS_END_DATE")
	private Date accessEndDate;
	@Column(name="COMMENTS",columnDefinition = CommonUtils.VARCHAR_500)
	private String comments;
	@Column(name="ACTIVE_STATUS", columnDefinition = CommonUtils.DEFAULT)
	private Integer activeStatus;
	public Integer getMenuAccessId() {
		return menuAccessId;
	}
	public SubMenus getMenu() {
		return menu;
	}
	public User getUser() {
		return user;
	}
	public Date getAccessStartDate() {
		return accessStartDate;
	}
	public Date getAccessEndDate() {
		return accessEndDate;
	}
	public String getComments() {
		return comments;
	}
	public Integer getActiveStatus() {
		return activeStatus;
	}
	public void setMenuAccessId(Integer menuAccessId) {
		this.menuAccessId = menuAccessId;
	}
	public void setMenu(SubMenus menu) {
		this.menu = menu;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAccessStartDate(Date accessStartDate) {
		this.accessStartDate = accessStartDate;
	}
	public void setAccessEndDate(Date accessEndDate) {
		this.accessEndDate = accessEndDate;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}
	
}

 

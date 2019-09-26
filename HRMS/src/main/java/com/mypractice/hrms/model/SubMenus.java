 /**
 * 
 */
 package com.mypractice.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mypractice.hrms.util.CommonUtils;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 10:29:39 pm
 * SubMenus.java
 */
@Entity
@Table(name = "SUB_MENUS")
public final class SubMenus extends BaseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1867670097329527902L;
	@Id
	@Column(name = "SUB_MENU_ID", columnDefinition = CommonUtils.VARCHAR_100)
	private String subMenuId;
	@Column(name = "SUB_MENU_NAME", columnDefinition = CommonUtils.VARCHAR_50)
	private String subMenuName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID" , foreignKey = @ForeignKey(name="FK_SUMENU_ROLE_ID"))
	@JsonIgnore 
	private UserRole useRole;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID" , foreignKey = @ForeignKey(name="FK_MENU_ID"))
	@JsonIgnore 
	private Menus menu;
	
	public UserRole getUseRole() {
		return useRole;
	}
	public void setUseRole(UserRole useRole) {
		this.useRole = useRole;
	}
	public String getSubMenuId() {
		return subMenuId;
	}
	public String getSubMenuName() {
		return subMenuName;
	}
	public Menus getMenu() {
		return menu;
	}
	public void setMenu(Menus menu) {
		this.menu = menu;
	}
	public void setSubMenuId(String subMenuId) {
		this.subMenuId = subMenuId;
	}
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}
	@Override
	public String toString() {
		return "SubMenus [subMenuId=" + subMenuId + ", subMenuName=" + subMenuName + ", menu=" + menu + "]";
	}
	
	
}

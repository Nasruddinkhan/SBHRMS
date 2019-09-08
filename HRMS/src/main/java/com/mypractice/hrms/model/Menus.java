 /**
 * 
 */
 package com.mypractice.hrms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mypractice.hrms.util.CommonUtils;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 12:56:06 am
 * Menus.java
 */
@Entity
@Table(name = "MENUS")
public final class Menus extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MENU_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_master")
	@SequenceGenerator(name="menu_master", sequenceName = "menu_seq", allocationSize=1,initialValue = 3000)
	private Integer menuID;
	@NotBlank(message = "menu name is mandatory")
	@Column(name = "MENU_NAME", columnDefinition = CommonUtils.VARCHAR_100)
	private String menuName;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getMenuID() {
		return menuID;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
}

 

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
 * 24-Aug-2019 - 11:37:00 pm
 * UserRole.java
 */
@Entity
@Table(name = "USER_ROLE")
final public class UserRole extends BaseBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7672723416234207136L;
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_master")
	@SequenceGenerator(name="role_master", sequenceName = "role_seq", allocationSize=1,initialValue = 2000)
	private Integer roleID;
	@NotBlank(message = "role name is mandatory")
	@Column(name = "ROLE_NAME", columnDefinition = CommonUtils.VARCHAR_20)
	private String roleName;
	public Integer getRoleID() {
		return roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}

 

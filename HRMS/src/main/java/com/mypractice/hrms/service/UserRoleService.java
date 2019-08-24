 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import com.mypractice.hrms.model.UserRole;

/**
 * @author Nasruddin Khan 
 * 25-Aug-2019 - 12:07:50 am
 * UserRoleService.java
 */
public interface UserRoleService {
	UserRole saveUserRole(UserRole role);

	/**
	 * @param roleID
	 * @return
	 */
	Optional<UserRole> findOne(Integer roleID);

	/**
	 * @param userRole
	 */
	void deleteRole(UserRole userRole);

	/**
	 * @return
	 */
	List<UserRole> findAll();

}

 

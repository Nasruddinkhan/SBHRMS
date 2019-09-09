 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.mypractice.hrms.model.Menus;
import com.mypractice.hrms.model.UserRole;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 1:06:21 am
 * MenuService.java
 */
public interface MenuService {

	/**
	 * @param userRole
	 * @return
	 */
	Menus saveUserRole(Menus menus);

	/**
	 * @return
	 */
	List<Menus> findAll();

	/**
	 * @param menuID
	 * @return
	 */
	Optional<Menus> findOne(Integer menuID);

	/**
	 * @param menus
	 */
	void deleteMenu(Menus menus);

}

 

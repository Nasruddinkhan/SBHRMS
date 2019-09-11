 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;

import com.mypractice.hrms.model.SubMenus;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 11:21:21 pm
 * SubMenuService.java
 */
public interface SubMenuService {

	/**
	 * @param subMenus
	 * @return 
	 */
	SubMenus save( SubMenus subMenus);

	/**
	 * @return
	 */
	List<SubMenuDetails> findAll();

	/**
	 * @param subMenuID
	 * @return
	 */
	SubMenus findOne(String subMenuID);

	/**
	 * @param submenID
	 */
	void deleteSubMenu(String submenID);

}

 

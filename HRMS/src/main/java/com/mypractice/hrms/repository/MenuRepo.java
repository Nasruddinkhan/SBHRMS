 /**
 * 
 */
 package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.Menus;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 1:11:10 am
 * MenuRepo.java
 */
@Repository
public interface MenuRepo extends JpaRepository<Menus, Integer> {

	/**
	 * @return
	 */
	

}

 

 /**
 * 
 */
 package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mypractice.hrms.model.MenuAccessRole;
import com.mypractice.hrms.model.User;

/**
 * @author Nasruddin Khan 
 * 27-Sep-2019 - 12:11:38 am
 * MenuAccessRoleRepo.java
 */
public interface MenuAccessRoleRepo extends JpaRepository<MenuAccessRole, Integer> {

	/**
	 * @return
	 */
	@Query("from MenuAccessRole where user = :USER")
	List<MenuAccessRole> findAllSubMenus(@Param("USER")  User user);

}

 

 /**
 * 
 */
 package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.SubMenus;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 11:24:02 pm
 * SubMenuRepo.java
 */
@Repository
public interface SubMenuRepo extends JpaRepository<SubMenus, String> {

}

 

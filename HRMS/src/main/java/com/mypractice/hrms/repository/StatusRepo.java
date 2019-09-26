 /**
 * 
 */
 package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.StatusMaster;

/**
 * @author Nasruddin Khan 
 * 31-Aug-2019 - 2:15:44 pm
 * StatusRepo.java
 */
@Repository
public interface StatusRepo extends JpaRepository<StatusMaster, String> {

}

 

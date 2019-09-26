 /**
 * 
 */
 package com.mypractice.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.EmailTemplates;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:42:27 pm
 * EmailTemplatesRepo.java
 */
@Repository
public interface EmailTemplatesRepo extends JpaRepository<EmailTemplates, Integer> {


}

 

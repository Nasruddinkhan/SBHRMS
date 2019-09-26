 /**
 * 
 */
 package com.mypractice.hrms.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.hrms.model.EmailHistory;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:43:33 pm
 * EmailHistoryRepo.java
 */
@Repository
public interface EmailHistoryRepo extends JpaRepository<EmailHistory, Integer> {
	
	@Query("from EmailHistory h  where h.isEmailSent = 'N' ")
	List<EmailHistory> getTemplates();

	@Modifying
	@Query("update EmailHistory set isEmailSent = 'Y' , modifiedDate = :UPDATE , modifiedBy = 'SYSTEM' where emailHistory IN (:HISTORYID)")
	Integer upDateEmailHistoryFlag(@Param("HISTORYID") List<Integer> lists,@Param("UPDATE") Timestamp currentTime);
}

 

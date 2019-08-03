 /**
 * 
 */
 package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mypractice.hrms.model.SkillElementMaster;

/**
 * @author Nasruddin Khan 
 * 02-Aug-2019 - 1:10:54 am
 * SkillElementRepo.java
 */
public interface SkillElementRepo extends JpaRepository<SkillElementMaster, Integer> {
	
	@Query("select e.skillElementID as skillElementID, e.skillElementName as skillElementName, e.orderlevl as orderlevl, s.skillName as skillName, s.skillID as skillID ,"
			+ " e.activeStatus as activeStatus, e.modifiedBy as modifiedBy, e.createdBy as createdBy, e.createdDate as createdDate, e.modifiedBy as modifiedBy, e.activeStatus as activeStatus from SkillElementMaster e inner join SkillMaster s on s.skillID=e.skillMst")
    List<SkillElelentsDetails> getSkillElementsDetails();
}

 

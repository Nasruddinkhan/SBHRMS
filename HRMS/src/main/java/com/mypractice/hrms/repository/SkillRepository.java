 /**
 * 
 */
 package com.mypractice.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.mypractice.hrms.model.SkillMaster;

/**
 * @author Nasruddin Khan 
 * 28-May-2019 - 1:44:00 am
 * SkillRepository.java
 */
public interface SkillRepository extends JpaRepository<SkillMaster, Integer> {
	/**
	 * @return
	 */
	@Query("Select s from SkillMaster s where activeStatus = 1")
	List<SkillMaster> findAllActiveSkills();

	/**
	 * @param skillId
	 * @return
	 */
	@Modifying
	@Query("Update SkillMaster set activeStatus = 0 where skillID =:SKILLID")
	Integer deleteSkill(@Param("SKILLID") Integer skillId);
	
	@Query("select skillID as ID, skillName as code  from SkillMaster")
	List<CommonDropdown> getSkills();
	
}

 

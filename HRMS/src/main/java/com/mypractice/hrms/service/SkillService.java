 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import com.mypractice.hrms.model.SkillMaster;

/**
 * @author Nasruddin Khan 
 * 28-May-2019 - 1:38:37 am
 * SkillService.java
 */
public interface SkillService {

	/**
	 * @param skillMaster
	 * @return if record added then return successfully other wise return user friendly message
	 */
	SkillMaster saveNewkill(SkillMaster skillMaster);

	/**
	 * @return return all skill data
	 */
	List<SkillMaster> getSkillDetails();

	/**
	 * @param skillID
	 * @return
	 */
	Optional<SkillMaster> findOne(Integer skillID);

	/**
	 * @param sklMst
	 */
	void deleteSkill(SkillMaster sklMst);

}

 

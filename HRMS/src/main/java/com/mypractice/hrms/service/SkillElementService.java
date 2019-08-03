 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import com.mypractice.hrms.model.SkillElementMaster;

/**
 * @author Nasruddin Khan 
 * 02-Aug-2019 - 1:06:22 am
 * SkillElementService.java
 */

public interface SkillElementService {

	/**
	 * @param skillMaster
	 * @return
	 */
	SkillElementMaster saveSkillElement(SkillElementMaster skillMaster);

	/**
	 * @return
	 */
	List<SkillElementMaster> findAll();

	/**
	 * @param sklMst
	 */
	void deleteSkill(SkillElementMaster sklMst);

	/**
	 * @param skillEleId
	 * @return
	 */
	Optional<SkillElementMaster> findOne(Integer skillEleId);

}

 

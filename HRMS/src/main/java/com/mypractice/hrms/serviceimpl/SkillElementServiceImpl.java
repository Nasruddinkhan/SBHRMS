 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.model.SkillElementMaster;
import com.mypractice.hrms.repository.SkillElelentsDetails;
import com.mypractice.hrms.repository.SkillElementRepo;
import com.mypractice.hrms.service.SkillElementService;

/**
 * @author Nasruddin Khan 
 * 02-Aug-2019 - 1:06:56 am
 * SkillElementServiceImpl.java
 */
@Service("skillElementService")
@Transactional
public class SkillElementServiceImpl implements SkillElementService {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SkillElementRepo skillElementsRepo;
	@Override
	public SkillElementMaster saveSkillElement(SkillElementMaster skillMaster) {
		// TODO Auto-generated method stub
		System.out.println(skillMaster.getSkillMst().getSkillID());
		return skillElementsRepo.saveAndFlush(skillMaster);
	}
	@Override
	public List<SkillElementMaster> findAll() {
		// TODO Auto-generated method stub
		return skillElementsRepo.findAll();
	}
	@Override
	public void deleteSkill(SkillElementMaster sklMst) {
		// TODO Auto-generated method stub
		skillElementsRepo.delete(sklMst);
	}
	@Override
	public Optional<SkillElementMaster> findOne(Integer skillEleId) {
		// TODO Auto-generated method stub
		return skillElementsRepo.findById(skillEleId);
	}
	@Override
	public List<SkillElelentsDetails> findAllSkillElelentsDetails() {
		// TODO Auto-generated method stub
		return skillElementsRepo.getSkillElementsDetails();
	}
}

 

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

import com.mypractice.hrms.model.SkillMaster;
import com.mypractice.hrms.repository.CommonDropdown;
import com.mypractice.hrms.repository.SkillRepository;
import com.mypractice.hrms.service.SkillService;

/**
 * @author Nasruddin Khan 
 * 28-May-2019 - 1:42:44 am
 * SkillServiceImpl.java
 */
@Service("skillService")
@Transactional
public class SkillServiceImpl implements SkillService {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SkillRepository skillRepository=null;
	
	@Override
	public SkillMaster saveNewkill(SkillMaster skillMaster)  {
		// TODO Auto-generated method stub
		return skillRepository.saveAndFlush(skillMaster);
	}
	@Override
	public List<SkillMaster> getSkillDetails() {
		// TODO Auto-generated method stub
		return skillRepository.findAllActiveSkills();
	}
	
	@Override
	public Optional<SkillMaster> findOne(Integer skillID) {
		// TODO Auto-generated method stub
		return skillRepository.findById(skillID);
	}
	@Override
	public void deleteSkill(SkillMaster sklMst) {
		// TODO Auto-generated method stub
		skillRepository.delete(sklMst);
	}
	@Override
	public List<CommonDropdown> findAllSkills() {
		// TODO Auto-generated method stub
		return skillRepository.getSkills();
	}
}

 

 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.model.StatusMaster;
import com.mypractice.hrms.model.UserRole;
import com.mypractice.hrms.repository.StatusRepo;
import com.mypractice.hrms.service.StatusService;

/**
 * @author Nasruddin Khan 
 * 31-Aug-2019 - 2:11:45 pm
 * StatusServiceImpl.java
 */
@Transactional
@Service("statusService")
public class StatusServiceImpl implements StatusService {
@Autowired
private StatusRepo statusRepo;
	@Override
	public StatusMaster saveStatus(StatusMaster statusMaster) {
		// TODO Auto-generated method stub
		return statusRepo.save(statusMaster);
	}
	@Override
	public List<StatusMaster> findAll() {
		// TODO Auto-generated method stub
		return statusRepo.findAll();
	}
	@Override
	public Optional<StatusMaster> findOne(String statusID) {
		// TODO Auto-generated method stub
		return statusRepo.findById(statusID);
	}
	
	@Override
	public void deleteStatus(StatusMaster statusMaster) {
		// TODO Auto-generated method stub
		 statusRepo.delete(statusMaster);
	}
}

 

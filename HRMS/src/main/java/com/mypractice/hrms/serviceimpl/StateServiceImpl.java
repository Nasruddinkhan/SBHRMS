package com.mypractice.hrms.serviceimpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.model.StateMaster;
import com.mypractice.hrms.repository.StateRepo;
import com.mypractice.hrms.service.StateService;

@Transactional
@Service("stateService")
public class StateServiceImpl implements StateService {
	@Autowired
	private StateRepo stateRepo;
	@Override
	public StateMaster save(StateMaster stateMaster) {
		// TODO Auto-generated method stub
		return stateRepo.save(stateMaster);
	}
	@Override
	public List<StateMaster> findAll() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}
}

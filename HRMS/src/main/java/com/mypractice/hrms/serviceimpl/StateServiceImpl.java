package com.mypractice.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.hrms.model.StateMaster;
import com.mypractice.hrms.repository.CommonDropdown;
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
	@Override
	public Optional<StateMaster> findOne(Integer stateID) {
		// TODO Auto-generated method stub
		return stateRepo.findById(stateID);
	}
	@Override
	public void deleteState(StateMaster sttMst) {
		// TODO Auto-generated method stub
		stateRepo.delete(sttMst);
	}
	@Override
	public List<StateMaster> getStateDetails() {
		// TODO Auto-generated method stub
		return stateRepo.findAllActiveStates();
	}
	@Override
	public List<CommonDropdown> findAllStates() {
		// TODO Auto-generated method stub
		return stateRepo.getStates();
	}
}
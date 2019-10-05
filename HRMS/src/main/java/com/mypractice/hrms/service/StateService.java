package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import com.mypractice.hrms.model.StateMaster;
import com.mypractice.hrms.repository.CommonDropdown;

public interface StateService {

	StateMaster save(StateMaster stateMaster);
	List<StateMaster> findAll();
	Optional<StateMaster> findOne(Integer stateID);
	void deleteState(StateMaster sttMst);
	List<StateMaster> getStateDetails();
	List<CommonDropdown> findAllStates();

}

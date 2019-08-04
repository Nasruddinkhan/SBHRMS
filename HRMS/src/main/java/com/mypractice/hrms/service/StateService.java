package com.mypractice.hrms.service;

import java.util.List;

import com.mypractice.hrms.model.StateMaster;

public interface StateService {

	StateMaster save(StateMaster stateMaster);

	List<StateMaster> findAll();

}

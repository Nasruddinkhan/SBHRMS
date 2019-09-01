 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;
import java.util.Optional;

import com.mypractice.hrms.model.StatusMaster;
import com.mypractice.hrms.model.UserRole;

/**
 * @author Nasruddin Khan 
 * 31-Aug-2019 - 2:08:07 pm
 * StatusService.java
 */
public interface StatusService {

	/**
	 * @param statusMaster
	 * @return
	 */
	StatusMaster saveStatus( StatusMaster statusMaster);

	/**
	 * @return
	 */
	List<StatusMaster> findAll();

	/**
	 * @param statusID
	 * @return
	 */
	Optional<StatusMaster> findOne(String statusID);

	/**
	 * @param userRole
	 */
	void deleteStatus(StatusMaster statusMaster);

}

 

 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.service.SearchEmployeeService;

/**
 * @author Nasruddin Khan 
 * 04-Sep-2019 - 7:39:00 pm
 * SearchEmployeeServiceImpl.java
 */
@Transactional
@Service("searchEmployeeService")
public class SearchEmployeeServiceImpl implements SearchEmployeeService {
@Autowired
private UserRepository user;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return user.findAll();
	}

}

 

 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypractice.hrms.bean.LoginBO;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.service.LoginService;

/**
 * @author Nasruddin Khan 
 * 03-Sep-2019 - 2:35:00 pm
 * LoginServiceImpl.java
 */
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public User checkDBLogin(LoginBO loginBO) {
		// TODO Auto-generated method stub
		return userRepository.checkUserIDAndPassword(loginBO.getUsername(), loginBO.getPassword());
	}

}

 

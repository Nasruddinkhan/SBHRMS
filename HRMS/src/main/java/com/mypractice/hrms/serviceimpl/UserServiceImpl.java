 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypractice.hrms.bean.ResponseMessage;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.service.UserService;

/**
 * @author Nasruddin Khan 
 * 30-Aug-2019 - 1:27:18 am
 * UserServiceImpl.java
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}
	@Override
	public User checkEmail(String email) {
	
		return userRepo.findUserByEmailID(email);
	}
	@Override
	public ResponseMessage genrateRoleAccessMenu(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}

 

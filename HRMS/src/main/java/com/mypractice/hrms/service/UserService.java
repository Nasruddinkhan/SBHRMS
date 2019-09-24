 /**
 * 
 */
 package com.mypractice.hrms.service;

import com.mypractice.hrms.bean.ResponseMessage;
import com.mypractice.hrms.model.User;

/**
 * @author Nasruddin Khan 
 * 30-Aug-2019 - 1:22:22 am
 * UserService.java
 */
public interface UserService {

	/**
	 * @param user
	 * @return
	 */
	User registerUser(User user);

	/**
	 * @param email
	 * @return
	 */
	User checkEmail(String email);
	
	ResponseMessage genrateRoleAccessMenu(String email);

}

 

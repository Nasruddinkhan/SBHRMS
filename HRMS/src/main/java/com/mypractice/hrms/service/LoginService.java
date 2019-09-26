 /**
 * 
 */
 package com.mypractice.hrms.service;

import com.mypractice.hrms.bean.LoginBO;
import com.mypractice.hrms.model.User;

/**
 * @author Nasruddin Khan 
 * 03-Sep-2019 - 2:30:56 pm
 * LoginService.java
 */
public interface LoginService {

	/**
	 * @param loginBO
	 * @return
	 */
	User checkDBLogin(LoginBO loginBO);

}

 

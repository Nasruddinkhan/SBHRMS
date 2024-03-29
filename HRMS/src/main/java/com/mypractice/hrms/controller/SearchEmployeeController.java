 /**
 * 
 */
 package com.mypractice.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 
 * 04-Sep-2019 - 7:34:02 pm
 * SearchEmployeeController.java
 */
@RestController
@RequestMapping("/hrms/api/")
public  class SearchEmployeeController {
	@Autowired
	private  UserRepository userRepository;
	@ApiOperation(value="find all users",  notes = "return all user list")
	@GetMapping("searchemployees/emplist")
	public List<User> findAll(){
		return userRepository.findAll();
	}
}

 

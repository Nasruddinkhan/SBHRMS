 /**
 * 
 */
 package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.hrms.model.StatusMaster;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.service.StatusService;
import com.mypractice.hrms.service.UserService;
import com.mypractice.hrms.util.EmailTaskService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 
 * 30-Aug-2019 - 1:19:40 am
 * UserController.ssjava
 */
 @RestController
 @RequestMapping("/hrms/api/")
 public class UserController {
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private StatusService statusService;
	 
	 @Autowired
	 EmailTaskService emailTaskService;
	 @Value("${app.pending_for_app}")
	 private   Integer pendingForRegistration; 
	 
	 @Value("${app.chg_password}")
	 private   Integer changePassword;
	 
	 @ApiOperation(value = "register user details Skill Details", notes = "Returns the  ResponseMessage  in body.")
	 @PostMapping("/user/{statusID}/register")
	 public ResponseEntity<Object> saveUserDetails(@RequestBody User user,@PathVariable String statusID) throws JsonProcessingException {
		 URI UriLocation = null;
		 Predicate<User> chkUser =u-> userService.checkEmail(u.getEmail()) != null;
		 if(!chkUser.test(user)) {
			Optional<StatusMaster> appStatus = statusService.findOne(statusID);
			if(!appStatus.isPresent()) 
				 throw new  ResourceNotFoundException("Internal error contect with support team");
			user.setStatusMaster(appStatus.get());
			 User usr = userService.registerUser(user);
			 UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userID}").buildAndExpand(usr.getUserID()).toUri();
			 emailTaskService.createMailData(new ObjectMapper().writeValueAsString(usr), "Nasruddin Khan",
					 usr.getEmail(),"Nasruddinkhan44@gmail.com", "User", pendingForRegistration);
		 }else 
			 throw new ResourceNotFoundException("email is already register "+ user.getEmail());
		 return ResponseEntity.created(UriLocation).build();
	 }	
	 
	 @ApiOperation(value = "register user details Skill Details", notes = "Returns the  ResponseMessage  in body.")
	 @GetMapping("/user/{emailID}/{password}/{userType}/chgpassword")
	 public ResponseEntity<Object> changePassword(@PathVariable String emailID, @PathVariable String password, @PathVariable String userType) throws JsonProcessingException {
		System.out.println("call properly "+ emailID +" "+password+" "+userType);
		 URI UriLocation = null;
		 Predicate<String> chkUser =u-> userService.checkEmail(u) != null;
		 if(chkUser.test(emailID)) {
			 User user = userService.checkEmail(emailID);
			 user.setPassword(password);
			 user.setUserType(userType);
			 User usr = userService.registerUser(user);
			 UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userID}").buildAndExpand(usr.getUserID()).toUri();
			 emailTaskService.createMailData(new ObjectMapper().writeValueAsString(usr), "Nasruddin Khan",
					 usr.getEmail(),"Nasruddinkhan44@gmail.com", "User", changePassword);
		 }else 
			 throw new ResourceNotFoundException("email is already register "+ emailID);
		 return ResponseEntity.created(UriLocation).build();
	 }
}

 

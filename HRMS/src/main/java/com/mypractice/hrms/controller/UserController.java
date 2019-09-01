 /**
 * 
 */
 package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.hrms.model.User;
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
	 EmailTaskService emailTaskService;
	 @Value("${app.pending_for_app}")
	 private   Integer pendingForRegistration; 
	 @ApiOperation(value = "register user details Skill Details", notes = "Returns the  ResponseMessage  in body.")
	 @PostMapping("/user/register")
	 public ResponseEntity<Object> saveUserDetails(@RequestBody User user) throws JsonProcessingException {
		 URI UriLocation = null;
		 Predicate<User> chkUser =u-> userService.checkEmail(u.getEmail()) != null;
		 if(!chkUser.test(user)) {
			 User usr = userService.registerUser(user);
			 UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userID}").buildAndExpand(usr.getUserID()).toUri();
			 emailTaskService.createMailData(new ObjectMapper().writeValueAsString(usr), "Nasruddin Khan",
					 usr.getEmail(),"Nasruddinkhan44@gmail.com", "User", pendingForRegistration);
		 }else 
			 throw new ResourceNotFoundException("email is already register "+ user.getEmail());
		 return ResponseEntity.created(UriLocation).build();
	 }	 
}

 

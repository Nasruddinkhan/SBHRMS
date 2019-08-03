 /**
 * 
 */
 package com.mypractice.hrms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mypractice.hrms.bean.LoginBO;
import com.mypractice.hrms.bean.ResponseMessage;
import com.mypractice.hrms.security.JwtGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:42:56 am
 * LoginController.java
 */
 @CrossOrigin(origins = { "*" })  
 @RestController
 @RequestMapping("/hrms/api/")
public class LoginController {

		protected final Logger log = LoggerFactory.getLogger(this.getClass());
		
		@Autowired
		JwtGenerator jwtGenerator;
		
		@PostMapping(value = "login/validateUser")
		@ApiOperation(value = "LoginBO Bo.", notes = "validate the login user.")
		public  ResponseEntity<?> validate(@ApiParam(value = "LoginBO Bo is required", required = true)@RequestBody LoginBO loginBO) {
			
			ResponseMessage msg=new ResponseMessage();
			try{
			// TODO Auto-generated method stub
			boolean isError =true;
			//UsersDetails details = loginService.checkDBLogin(loginBean);
			if(isError) {
				//System.out.println("LoginController.validate() ["+loginService+"]");
					msg.setErrorCode(200);
					msg.setErrorMessage("Success");
					//int sessionTimeOut = (30*60);
					String token= jwtGenerator.generate(loginBO);
					msg.setToken(token);
					return new ResponseEntity<>(msg,HttpStatus.OK);
				
			}else {
				msg.setErrorCode(-200);
				msg.setErrorMessage("Error");
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

 

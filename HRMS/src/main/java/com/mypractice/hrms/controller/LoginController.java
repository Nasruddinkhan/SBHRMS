 /**
 * 
 */
 package com.mypractice.hrms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.hrms.bean.DropDownBean;
import com.mypractice.hrms.bean.LoginBO;
import com.mypractice.hrms.bean.ResponseMessage;
import com.mypractice.hrms.model.SubMenus;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.MenuAccessRoleRepo;
import com.mypractice.hrms.repository.SubMenuRepo;
import com.mypractice.hrms.security.JwtGenerator;
import com.mypractice.hrms.service.LoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:42:56 am
 * LoginController.java
 */
 @RestController
 @RequestMapping("/hrms/api/")
 public class LoginController {

	 protected final Logger log = LoggerFactory.getLogger(this.getClass());
	 @Value("${app.approve.status}")
	 private String approved;
	 @Autowired
	 private MenuAccessRoleRepo menuRepo;
	 @Autowired
	 private SubMenuRepo subMenuRepo;
	 
	 @Autowired
	 JwtGenerator jwtGenerator;
	 @Autowired
	 private LoginService loginService;

	 @PostMapping(value = "login/validateUser")
	 @ApiOperation(value = "LoginBO Bo.", notes = "validate the login user.")
	 public  ResponseEntity<?> validate(@ApiParam(value = "LoginBO Bo is required", required = true)@RequestBody LoginBO loginBO) {
		 ResponseMessage msg=new ResponseMessage();
		 // TODO Auto-generated method stub
		 User details = loginService.checkDBLogin(loginBO);
		 List<DropDownBean>  accessMenus = null;
		 Predicate<User> check= u -> u != null;
		 if(check.test(details)) {
			 Predicate<String> checkStatus= s -> approved.intern() ==s.intern() ;
			 System.out.println(details.getStatusMaster().getStatusID()+ " "+approved);
			 if(checkStatus.test(details.getStatusMaster().getStatusID())) {
				 Function<String, Integer> errorApply = t ->  t.intern() == "FTL"?205:200;
				 msg.setErrorCode(errorApply .apply(details.getUserType()));
				 msg.setErrorMessage("Success");
				 msg.setToken(jwtGenerator.generate(loginBO));
				 Map<String, List<DropDownBean>> acceessMenu = new HashMap<String, List<DropDownBean>>();
				 List<String>  suBmenus =menuRepo.findAllSubMenus(details).stream().map(c->c.getMenu().getSubMenuId()).collect(Collectors.toList());
				 if(suBmenus !=null && suBmenus.size()>0) 
					 accessMenus=  subMenuRepo.findAll(suBmenus).stream().map(o->{
						   DropDownBean drop = new DropDownBean();
						   drop.setId(o.getSubMenuId());
						   drop.setCode( o.getSubMenuName());
						   return drop;
					 }).collect(Collectors.toList());
				 acceessMenu.put("menus", accessMenus);
				 msg.setMap(acceessMenu);
				 msg.setUser(details);
				 return new ResponseEntity<>(msg,HttpStatus.OK);
			 }
			 throw new RuntimeException("Inactive user! Application is pending for registration");
		 }
		 throw new RuntimeException("Invalid credential! user id password is incorrect " );
	 }
}

 

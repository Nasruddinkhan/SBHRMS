 /**
 * 
 */
 package com.mypractice.hrms.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.UserRole;
import com.mypractice.hrms.service.UserRoleService;

import io.swagger.annotations.ApiOperation;
/**
 * @author Nasruddin Khan 
 * 24-Aug-2019 - 11:54:01 pm
 * UserController.java
 */
 @RestController
 @RequestMapping("/hrms/api/")
 public class UserRoleController {
	 @Autowired
	 private UserRoleService userRoleService;
	 @ApiOperation(value = "add new role Details.", notes = "Returns the  ResponseMessage  in body.")
	 @PostMapping("role/add")
	 public ResponseEntity<Object> saveSkillDetails(@Valid @RequestBody UserRole userRole) {
		 UserRole usRole = userRoleService.saveUserRole(userRole);
		 URI UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{roleID}")
				 .buildAndExpand(usRole.getRoleID()).toUri();
		 return ResponseEntity.created(UriLocation).build();
	 }
	 @ApiOperation(value = "delete  role .", notes = "Returns the  ResponseMessage  in body.")
	 @DeleteMapping("role/{roleID}/delete")
	 public void deleteRole(@PathVariable Integer roleID) {
		 Optional<UserRole> userRole = userRoleService.findOne(roleID);
		 if(!userRole.isPresent())
			 throw new ResourceNotFoundException("Role id is not found ="+roleID);
		 userRoleService.deleteRole(userRole.get());
	 }
	 @ApiOperation(value = "get all  role .", notes = "Returns the  ResponseMessage  in body.")
	 @GetMapping("role/roles")
	 public List<UserRole> findAll() {
		 List<UserRole> roles = userRoleService.findAll();
		 if(roles.isEmpty())
			 throw new ResourceNotFoundException("Role is not found");
		 return roles;
	 }
	 @ApiOperation(value = "add new Skill Details.", notes = "Returns the  ResponseMessage  in body.")
	 @GetMapping("/role/{roleID}/roleid")
	 public Resource<UserRole> getRole(@PathVariable Integer roleID) {
		 Optional<UserRole> userRole = userRoleService.findOne(roleID);
		 if (!userRole.isPresent()) {
			 throw new RuntimeException("role is not found" + roleID);
		 }
		 Resource<UserRole> userRoles= new Resource<UserRole>(userRole.get());
		 ControllerLinkBuilder links= linkTo(methodOn(this.getClass()).findAll());
		 userRoles.add(links.withRel("all-roles"));
		 return userRoles;
	 }
}

 

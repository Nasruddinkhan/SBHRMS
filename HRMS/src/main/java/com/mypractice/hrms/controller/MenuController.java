 /**
 * 
 */
 package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mypractice.hrms.model.Menus;
import com.mypractice.hrms.service.MenuService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 
 * 09-Sep-2019 - 1:03:18 am
 * MenuController.java
 */
 @RestController
 @RequestMapping("/hrms/api/")
public final class MenuController {
	 @Autowired
	 private MenuService menuService;
	 @ApiOperation(value = "add new menu Details.", notes = "Returns the  ResponseMessage  in body.")
	 @PostMapping("menu/add")
	 public ResponseEntity<Object> saveSkillDetails(@Valid @RequestBody Menus menus) {
		 Menus usRole = menuService.saveUserRole(menus);
		 URI UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{menuID}")
				 .buildAndExpand(usRole.getMenuID()).toUri();
		 return ResponseEntity.created(UriLocation).build();
	 }
	 @ApiOperation(value = "add new menu Details.", notes = "Returns the  ResponseMessage  in body.")
	 @GetMapping("menu/menus")
	 public List<Menus> findAll(){
		return menuService.findAll();
	 }
	 
	 @ApiOperation(value = "delete menu", notes = "Returns the  ResponseMessage  in body.")
	 @DeleteMapping("menu/{menuID}/delete")
	 public void deleteRole(@PathVariable Integer menuID) {
		 Optional<Menus> userRole = menuService.findOne(menuID);
		 if(!userRole.isPresent())
			 throw new ResourceNotFoundException("Menu id is not found ="+menuID);
		 menuService.deleteMenu(userRole.get());
	 }
}

 

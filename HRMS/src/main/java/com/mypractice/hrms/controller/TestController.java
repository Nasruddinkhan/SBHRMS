package com.mypractice.hrms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * Nasruddin khan
 * TestController.java
 * Mar 11, 2019 6:43:30 PM
 */
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = { "*" })  
@RestController
@RequestMapping("/hrms/api")
public class TestController {
	@GetMapping
	//@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" },consumes={ "application/json" })
	@ApiOperation(value = "Get  Details.", notes = "Returns the  Details in body.")
	public String sayHello() {
		return "Hello";
	}
}

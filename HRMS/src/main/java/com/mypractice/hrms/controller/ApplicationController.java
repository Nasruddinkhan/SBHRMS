/**
 * nasru
 * ApplicationController.java
 * Jan 19, 2020
 */
package com.mypractice.hrms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.hrms.bean.ApplicationPreviewBean;
import com.mypractice.hrms.serviceimpl.GenrateApplication;
import com.mypractice.hrms.serviceimpl.UserServiceImpl;
import com.mypractice.hrms.util.CommonUtils;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping("/hrms/api/")
public class ApplicationController {

	@Autowired
	private UserServiceImpl userApplication;
	@Autowired
	private GenrateApplication genrateApplication;
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", 
	                      required = true, dataType = "string", paramType = "header") })
	@GetMapping("appliction/{userID}/previewapplication")
	public ResponseEntity<?> findUserDetails(@PathVariable Integer userID){
		return ResponseEntity.ok().body((userApplication.findUserDetails(userID)));
	}
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "Authorization", value = "Authorization token", 
	                      required = true, dataType = "string", paramType = "header") })
	@PostMapping("appliction/{userID}/downloadapplication")
	public ResponseEntity<?> findUserDetails(@PathVariable Integer userID,@RequestBody ApplicationPreviewBean bean) throws IOException{
		Map<String,String> map = new HashMap<>();
		map.put("encode",CommonUtils.readAndEncodeFile(genrateApplication.applicationForm(bean, userID)));
		return ResponseEntity
				.ok()
				.body(map);
	}
}

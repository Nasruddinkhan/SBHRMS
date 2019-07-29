 /**
 * 
 */
 package com.mypractice.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.hrms.model.SkillElementMaster;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 
 * 07-Jun-2019 - 4:12:17 pm
 * SkillElementMasterController.java
 */
@CrossOrigin(origins = { "*" })  
@RestController
@RequestMapping("/hrms/api/")
public class SkillElementMasterController {
	@ApiOperation(value = "add new new Skill elemrnt manster.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("/skillelementmaster")
	public ResponseEntity<?> saveSkillElementDetails(@RequestBody SkillElementMaster skillMaster) {
		return ResponseEntity.ok(skillMaster);
	}
}

 

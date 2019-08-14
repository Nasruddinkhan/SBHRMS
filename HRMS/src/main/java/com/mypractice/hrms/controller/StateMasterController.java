package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.model.StateMaster;
import com.mypractice.hrms.service.StateService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" })  
@RestController
@RequestMapping("/hrms/api/")
public class StateMasterController {
	
	@Autowired
	private StateService stateService;
	
	@ApiOperation(value = "add new state Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("statemst/savestate")
	public ResponseEntity<Object> saveSate(@RequestBody StateMaster stateMaster) {
		StateMaster skillmst = stateService.save(stateMaster);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{stateID}")
				.buildAndExpand(skillmst.getStateID()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation(value = "returns all state details.", notes = "Returns state the  ResponseMessage  in body.")
	@GetMapping("statemst/satedls")
	public List<StateMaster> findAll(){
		List<StateMaster> lst = stateService.findAll();
		if(lst.isEmpty()) {
			throw new RuntimeException("No record found");
		}
		return lst;
	}
}

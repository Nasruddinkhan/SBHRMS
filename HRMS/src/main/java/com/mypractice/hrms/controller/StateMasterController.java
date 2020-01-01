package com.mypractice.hrms.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.mypractice.hrms.model.StateMaster;
import com.mypractice.hrms.repository.StateRepo;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hrms/api/")
public class StateMasterController {	
	@Autowired
	private StateRepo stateRepo;
	
	@ApiOperation(value = "add new state Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("statemst/savestate")
	public ResponseEntity<Object> saveState(@RequestBody StateMaster stateMaster) {
		StateMaster skillmst = stateRepo.save(stateMaster);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{stateID}")
				.buildAndExpand(skillmst.getStateID()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation(value = "returns all state details.", notes = "Returns state the  ResponseMessage  in body.")
	@GetMapping("statemst/getAllStateDetails")
	public List<StateMaster> findAll(){
		List<StateMaster> lst = stateRepo.findAll();
		if(lst.isEmpty()) 
			throw new RuntimeException("No record found");
		return lst;
	}
	@ApiOperation(value = "add new State Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/statemst/{stateID}/state")
	public Resource<StateMaster> getState(@PathVariable Integer stateID) {
		Optional<StateMaster> statemaster = stateRepo.findById(stateID);
		if (!statemaster.isPresent()) {
			throw new RuntimeException("stateid is not found" + stateID);
		}
		Resource<StateMaster> stateResource= new Resource<StateMaster>(statemaster.get());
		ControllerLinkBuilder links= linkTo(methodOn(this.getClass()).getStateDetails());
		stateResource.add(links.withRel("all-states"));
		return stateResource;
	}
	@ApiOperation(value = "add new State Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/statemaster/getstates")
	public List<StateMaster> getStateDetails() {
		System.out.println("StateMasterController.getStateDetails()");
		List<StateMaster> sttmst = stateRepo.findAllActiveStates();
		System.out.print(sttmst);
		if (sttmst.isEmpty()) 
			throw new ResourceNotFoundException("Record Not Found");
		return sttmst;
	}
	@ApiOperation(value = "add new State Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/statemst/{stateId}/deletestate")
	public void deleteState(@PathVariable("stateId") Integer stateId) {
		Optional<StateMaster> statemaster = stateRepo.findById(stateId);
		if (!statemaster.isPresent()) 
			throw new RuntimeException("stateId is not found" + stateId);
		StateMaster sttMst = statemaster.get();
		stateRepo.delete(sttMst);
	}}

/**
 * 
 */
package com.mypractice.hrms.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.SkillMaster;
import com.mypractice.hrms.service.SkillService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 28-May-2019 - 1:32:48 am SkillMasterController.java
 */
@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/hrms/api/")
public class SkillMasterController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SkillService skillService;

	@ApiOperation(value = "add new Skill Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("/skillmaster/saveskill")
	public ResponseEntity<Object> saveSkillDetails(@RequestBody SkillMaster skillMaster) {
		System.out.println(skillMaster);
		skillMaster = skillService.saveNewkill(skillMaster);
		URI UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{skillID}")
				.buildAndExpand(skillMaster.getSkillID()).toUri();
		return ResponseEntity.created(UriLocation).build();
	}

	@ApiOperation(value = "add new Skill Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/skillmaster/{skillID}/skill")
	public Resource<SkillMaster> getSkill(@PathVariable Integer skillID) {
		Optional<SkillMaster> skillmaster = skillService.findOne(skillID);
		if (!skillmaster.isPresent()) {
			throw new RuntimeException("skilid is not found" + skillID);
		}
		Resource<SkillMaster> skiResource= new Resource<SkillMaster>(skillmaster.get());
		ControllerLinkBuilder links= linkTo(methodOn(this.getClass()).getSkillDetails());
		skiResource.add(links.withRel("all-skills"));
		return skiResource;
	}

	@ApiOperation(value = "add new Skill Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/skillmaster/getskills")
	public List<SkillMaster> getSkillDetails() {
		System.out.println("SkillMasterController.getSkillDetails()");
		List<SkillMaster> sklmst = skillService.getSkillDetails();
		System.out.print(sklmst);
		if (sklmst.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found");
		}
		return sklmst;
	}
	@ApiOperation(value = "add new Skill Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/skillmaster/{skillId}/deleteskill")
	public void deleteSkill(@PathVariable("skillId") Integer skillId) {
		Optional<SkillMaster> skillmaster = skillService.findOne(skillId);
		if (!skillmaster.isPresent()) {
			throw new RuntimeException("skilid is not found" + skillId);
		}
		SkillMaster sklMst = skillmaster.get();
		skillService.deleteSkill(sklMst);
	}
}

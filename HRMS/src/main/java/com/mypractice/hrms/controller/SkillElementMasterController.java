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
import com.mypractice.hrms.model.SkillElementMaster;
import com.mypractice.hrms.model.SkillMaster;
import com.mypractice.hrms.repository.CommonDropdown;
import com.mypractice.hrms.repository.SkillElelentsDetails;
import com.mypractice.hrms.service.SkillElementService;
import com.mypractice.hrms.service.SkillService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 
 * 07-Jun-2019 - 4:12:17 pm
 * SkillElementMasterController.java
 */
@RestController
@RequestMapping("/hrms/api/")
public class SkillElementMasterController {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SkillElementService skillElementService;
	@Autowired
	private SkillService skillService;
    	
	@ApiOperation(value = "add new new Skill elemrnt manster.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("/skillelement/{skillID}/savesubskills")
	public ResponseEntity<?> saveSkillElementDetails(@Valid @RequestBody SkillElementMaster skillelementMaster, @PathVariable("skillID") Integer skillId) {
		System.out.println(skillelementMaster);
		System.out.println(skillId);
		Optional<SkillMaster> skills = skillService.findOne(skillId);
		if(!skills.isPresent())
			throw new ResourceNotFoundException("skill is not found ="+skillId);
		skillelementMaster.setSkillMst(skills.get());
		SkillElementMaster sklEle= skillElementService.saveSkillElement(skillelementMaster);
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{skillementID}")
				.buildAndExpand(sklEle.getSkillElementID()).toUri();
		return ResponseEntity.created(uriLocation).build();
	}
	
	@ApiOperation(value = "areturns skills.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/skillelement/getskillelements")
	public List<SkillElementMaster> findAllSkillElements(){
		List<SkillElementMaster> sklmst = skillElementService.findAll();
		if (sklmst.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found");
		}
		return sklmst;
	}
	@ApiOperation(value = "delete  Skill elements Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/skillelement/{skillementID}/deleteskillelements")
	public void deleteSkillElements(@PathVariable("skillementID") Integer skillEleId) {
		Optional<SkillElementMaster> skillElementsmaster = skillElementService.findOne(skillEleId);
		if (!skillElementsmaster.isPresent()) {
			throw new RuntimeException("skillementID is not found" + skillEleId);
		}
		SkillElementMaster sklMst = skillElementsmaster.get();
		skillElementService.deleteSkill(sklMst);
	}
	
	@ApiOperation(value = "delete  Skill elements Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/skillmaster/{skillementID}/skillelements")
	public Resource<SkillElementMaster> getSkillElements(@PathVariable("skillementID") Integer skillEleId) {
		Optional<SkillElementMaster> skillElementsmaster = skillElementService.findOne(skillEleId);
		if (!skillElementsmaster.isPresent()) {
			throw new RuntimeException("skillementID is not found" + skillEleId);
		}
		SkillElementMaster sklMst = skillElementsmaster.get();
		Resource<SkillElementMaster> resource = new Resource<SkillElementMaster> (sklMst);
		ControllerLinkBuilder links= linkTo(methodOn(this.getClass()).findAllSkillElements());
		resource.add(links.withRel("all-skillelements"));
		return resource;
	}
	
	@ApiOperation(value = "areturns skills.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/skillelement/getskills")
	public List<CommonDropdown> findAllSkills(){
		List<CommonDropdown> sklmst = skillService.findAllSkills();
		if (sklmst.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found");
		}
		return sklmst;
	}
	@ApiOperation(value = "returns skill elelemts skills.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/skillelement/getskillelementsdetails")
	public List<SkillElelentsDetails> findAllSkillElelentsDetails(){
		List<SkillElelentsDetails> sklmst = skillElementService.findAllSkillElelentsDetails();
		if (sklmst.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found");
		}
		return sklmst;
	}
}

 

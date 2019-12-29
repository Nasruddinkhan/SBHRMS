/**
 * nasru
 * UniversityController.java
 * Dec 29, 2019
 */
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.Univercity;
import com.mypractice.hrms.repository.UniversityRepository;

import io.swagger.annotations.ApiOperation;

/**
 * @author nasru
 *
 */
public class UniversityController {
	@Autowired
	private UniversityRepository universityRepository;

	@ApiOperation(value = "add new university Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("university/add")
	public ResponseEntity<Object> saveUnivercityDetails( @RequestBody Univercity university) {
		Univercity universe = universityRepository.save(university);
		URI UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{universityID}")
				.buildAndExpand(universe.getUniversityID()).toUri();
		return ResponseEntity.created(UriLocation).build();
	}

	@ApiOperation(value = "add new university Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/university/getuniversitys")
	public List<Univercity> getUnivercityDetails() {
		List<Univercity> universitys = universityRepository.findAll();
		System.out.print(universitys);
		if (universitys.isEmpty())
			throw new ResourceNotFoundException("Record Not Found");
		return universitys;
	}

	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/university/{universityID}/get")
	public Resource<Univercity> getUnivercity(@PathVariable String universityID) {
		Optional<Univercity> universityMaster = universityRepository.findById(universityID);
		if (!universityMaster.isPresent())
			throw new RuntimeException("university is not found" + universityMaster);
		Resource<Univercity> cityResource = new Resource<Univercity>(universityMaster.get());
		ControllerLinkBuilder links = linkTo(methodOn(this.getClass()).getUnivercityDetails());
		cityResource.add(links.withRel("all-university"));
		return cityResource;
	}

	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/university/{universityID}/delete")
	public void deleteUniversity(@PathVariable String universityID) {
		Optional<Univercity> universityMaster = universityRepository.findById(universityID);
		if (!universityMaster.isPresent()) 
			throw new RuntimeException("university is not found" + universityID);
		Univercity universityMst = universityMaster.get();
		universityRepository.delete(universityMst);
	}
}

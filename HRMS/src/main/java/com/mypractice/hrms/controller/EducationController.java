/**
 * nasru
 * EducationController.java
 * Dec 30, 2019
 */
package com.mypractice.hrms.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import com.mypractice.hrms.model.Course;
import com.mypractice.hrms.model.Education;
import com.mypractice.hrms.model.Univercity;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.CourseRepository;
import com.mypractice.hrms.repository.EducationRepository;
import com.mypractice.hrms.repository.UniversityRepository;
import com.mypractice.hrms.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping("/hrms/api/")
public class EducationController {
	@Autowired
	private EducationRepository educationRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private UniversityRepository universityRepository;
	
	@ApiOperation(value = "add new education Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("education/{userID}/{universityID}/{courseID}/add")
	public ResponseEntity<Object> saveEducationDetails(@PathVariable Integer userID,
			@PathVariable String universityID, 
			@PathVariable String courseID, 
			@RequestBody Education education) {
		Optional<User> user =userRepository.findById(userID);
		Optional<Course> course = courseRepository.findById(courseID);
		Optional<Univercity> university=  universityRepository.findById(universityID);
		if(!user.isPresent() || !course.isPresent() || !university.isPresent())
			throw new ResourceNotFoundException("not found");
		education.setUser(user.get());
		Education edu = educationRepository.save(education);
		return ResponseEntity.created(ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{educationID}")
				.buildAndExpand(edu.getEducationID()).toUri()).build();
	}

	@ApiOperation(value = "add new education Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/education/geteducations")
	public List<Education> getEducationDetails() {
		List<Education> educations = educationRepository.findAll();
		System.out.print(educations);
		if (educations.isEmpty())
			throw new ResourceNotFoundException("Record Not Found");
		return educations;
	}

	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/education/{educationID}/get")
	public Resource<Education> getEducation(@PathVariable Integer educationID) {
		Optional<Education> educationMaster = educationRepository.findById(educationID);
		if (!educationMaster.isPresent())
			throw new RuntimeException("education is not found" + educationMaster);
		Resource<Education> eduResource = new Resource<Education>(educationMaster.get());
		ControllerLinkBuilder links = linkTo(methodOn(this.getClass()).getEducationDetails());
		eduResource.add(links.withRel("all-education"));
		return eduResource;
	}

	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/education/{educationID}/delete")
	public void deleteEducation(@PathVariable Integer educationID) {
		Optional<Education> educationMaster = educationRepository.findById(educationID);
		if (!educationMaster.isPresent()) 
			throw new RuntimeException("stateId is not found" + educationID);
		Education educationMst = educationMaster.get();
		educationRepository.delete(educationMst);
	}
}

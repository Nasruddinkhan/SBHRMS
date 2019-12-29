/**
 * nasru
 * CourseController.java
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.Course;
import com.mypractice.hrms.repository.CourseRepository;

import io.swagger.annotations.ApiOperation;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping("/hrms/api/")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;

	@ApiOperation(value = "add new course Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("course/add")
	public ResponseEntity<Object> saveCourseDetails( @RequestBody Course course) {
		Course curse = courseRepository.save(course);
		URI UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseID}")
				.buildAndExpand(curse.getCourseID()).toUri();
		return ResponseEntity.created(UriLocation).build();
	}

	@ApiOperation(value = "add new course Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/course/getcourses")
	public List<Course> getCourseDetails() {
		List<Course> courses = courseRepository.findAll();
		System.out.print(courses);
		if (courses.isEmpty())
			throw new ResourceNotFoundException("Record Not Found");
		return courses;
	}

	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/course/{courseID}/get")
	public Resource<Course> getCourse(@PathVariable String courseID) {
		Optional<Course> courseMaster = courseRepository.findById(courseID);
		if (!courseMaster.isPresent())
			throw new RuntimeException("course is not found" + courseMaster);
		Resource<Course> cityResource = new Resource<Course>(courseMaster.get());
		ControllerLinkBuilder links = linkTo(methodOn(this.getClass()).getCourseDetails());
		cityResource.add(links.withRel("all-course"));
		return cityResource;
	}

	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/course/{courseID}/delete")
	public void deleteCourse(@PathVariable String courseID) {
		Optional<Course> courseMaster = courseRepository.findById(courseID);
		if (!courseMaster.isPresent()) 
			throw new RuntimeException("stateId is not found" + courseID);
		Course courseMst = courseMaster.get();
		courseRepository.delete(courseMst);
		;
	}
}

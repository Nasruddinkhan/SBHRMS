/**
 * nasru
 * WorkStatausController.java
 * Mar 10, 2020
 */
package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.model.WorkStataus;
import com.mypractice.hrms.repository.SkillElementRepo;
import com.mypractice.hrms.repository.SkillRepository;
import com.mypractice.hrms.repository.UserRepository;
import com.mypractice.hrms.repository.WorkStatausRepo;

import io.swagger.annotations.ApiOperation;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping("/hrms/api/")
public class WorkStatausController {
	@Autowired
	private SkillElementRepo skillElementRepo;
	@Autowired
	private SkillRepository skillRepo;
	@Autowired
	private WorkStatausRepo workStsRepo;
	@Autowired
	private UserRepository userRepo;
	@ApiOperation(value = "add new role Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("workStataus/{skillID}/{skillEleID}/{userID}/add")
	public ResponseEntity<Object> saveWorkStatusDetails(@Valid @RequestBody WorkStataus workStataus,
			@PathVariable Integer skillID, 
			@PathVariable Integer skillEleID,
			@PathVariable Integer userID) {
		System.out.println(workStataus);
		List<WorkStataus> workList =workStsRepo.findBystartTime(workStataus.getStartTime(), workStataus.getEndTime());
		List<WorkStataus> works =workStsRepo.findByendTime(workStataus.getStartTime(), workStataus.getEndTime());
		if(!workList.isEmpty() || !works.isEmpty())
			throw new RuntimeException("Strat Tme and end time is overlap");
		workStataus.setSkillMst(skillRepo.findById(skillID).get());
		workStataus.setSkillElementMst(skillElementRepo.findById(skillEleID).get());
		workStataus.setUser(userRepo.findById(userID).get());
		WorkStataus wrkSts= workStsRepo.save(workStataus);
		URI UriLocation = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{workStatusID}")
				.buildAndExpand(wrkSts.getWorkStatusID())
				.toUri();
		return ResponseEntity.created(UriLocation).build();
	}
	@GetMapping("workStataus/{userID}/{pageNo}/remarks")
	public Page<WorkStataus> findAll(@PathVariable Integer userID, @PathVariable Integer pageNo ){
		Pageable  firstPageWithTwoElements  = PageRequest.of(pageNo-1, 10,  Sort.by("workStatusID").descending());
		Page<WorkStataus>  pageWorks = workStsRepo.findAllByuser(userRepo.findById(userID).get(), firstPageWithTwoElements);
		pageWorks.map(s-> setValues(s));
		return pageWorks;
	}
	/**
	 * @param s
	 * @return
	 */
	private WorkStataus setValues(WorkStataus s) {
		// TODO Auto-generated method stub
		 s.setSkillElementName(s.getSkillElementMst().getSkillElementName());
		 s.setSkillName(s.getSkillMst().getSkillName());
		return s;
	}
}

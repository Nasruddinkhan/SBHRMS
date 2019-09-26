/**
* 
*/
package com.mypractice.hrms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mypractice.hrms.model.StatusMaster;
import com.mypractice.hrms.service.StatusService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Nasruddin Khan 31-Aug-2019 - 2:00:35 pm StatusController.java
 */
@RestController
@RequestMapping("/hrms/api/")
public class StatusController {
	@Autowired
	private StatusService statusService;
	@ApiOperation(value = "add new status Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("status/add")
	public ResponseEntity<Object> saveSkillDetails(@Valid @RequestBody StatusMaster statusMaster) {
		StatusMaster statusMst = statusService.saveStatus(statusMaster);
		URI UriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{statusID}")
				.buildAndExpand(statusMst.getStatusID()).toUri();
		return ResponseEntity.created( UriLocation).build();
	}
	 @ApiOperation(value = "get all  status .", notes = "Returns the  ResponseMessage  in body.")
	 @GetMapping("status/statusdtls")
	 public List<StatusMaster> findAll() {
		 List<StatusMaster> statusMasters = statusService.findAll();
		 if(statusMasters.isEmpty())
			 throw new ResourceNotFoundException("Status is not found");
		 return statusMasters;
	 }
	 
	 @ApiOperation(value = "delete  role .", notes = "Returns the  ResponseMessage  in body.")
	 @DeleteMapping("status/{statusID}/delete")
	 public void deleteStatus(@PathVariable String statusID) {
		 System.out.println(statusID);
		 Optional<StatusMaster> statusMst = statusService.findOne(statusID);
		 if(!statusMst.isPresent())
			 throw new ResourceNotFoundException("Status id is not found ="+statusID);
		 statusService.deleteStatus(statusMst.get());
	 }
}

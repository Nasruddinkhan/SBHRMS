/**
 * nasru
 * AddressController.java
 * Dec 1, 2019
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mypractice.hrms.exception.ResourceNotFoundException;
import com.mypractice.hrms.model.Addresses;
import com.mypractice.hrms.model.CityMaster;
import com.mypractice.hrms.model.User;
import com.mypractice.hrms.repository.AddressDetails;
import com.mypractice.hrms.service.AddressService;
import com.mypractice.hrms.service.CityService;
import com.mypractice.hrms.service.UserService;

import io.swagger.annotations.ApiOperation;

/**
 * @author nasru
 *
 */
@RestController
@RequestMapping("/hrms/api/")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private CityService cityService;
	@Autowired
	private UserService userService;

	@ApiOperation(value = "add new address Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("address/{userid}/{cityid}/save")
	public ResponseEntity<?> addAddressDetails(@RequestBody Addresses addresses, @PathVariable Integer userid,
			@PathVariable("cityid") Integer cityID) {
		User usr = userService.findOne(userid).get();
		CityMaster cityMst = cityService.findOne(cityID).get();
		addresses.setUser(usr);
		addresses.setCityMst(cityMst);
		Addresses addr = addressService.saveAddress(addresses);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{addressID}")
				.buildAndExpand(addr.getAddressID()).toUri()).build();
	}

	@ApiOperation(value = "get address Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/address/{addressID}/getaddress")
	public Resource<Addresses> getAddress(@PathVariable Integer addressID) {
		Optional<Addresses> addMst = addressService.findOne(addressID);
		if (!addMst.isPresent()) {
			throw new RuntimeException("address is not found" + addressID);
		}
		Resource<Addresses> addResource = new Resource<Addresses>(addMst.get());
		ControllerLinkBuilder links = linkTo(methodOn(this.getClass()).getAddressDetails());
		addResource.add(links.withRel("all-add"));
		return addResource;
	}

	/**
	 * @return
	 */
	@ApiOperation(value = "get all address Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/address/getaddress")
	public List<Addresses> getAddressDetails() {
		// TODO Auto-generated method stub
		List<Addresses> address = addressService.findAll();
		if (address.isEmpty())
			throw new ResourceNotFoundException("Record Not Found");
		return address;
	}
	
	@ApiOperation(value = "get address Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/address/{userID}/useraddress")
	public AddressDetails getUserAddress(@PathVariable Integer userID) {
		System.out.println("address userID ["+userID+"]");
		AddressDetails address  = addressService.getUserAddress( userService.findOne(userID).get());
		if(address == null) 
			throw new ResourceNotFoundException("addrees not found"+ userID);
		return address;
	}

}

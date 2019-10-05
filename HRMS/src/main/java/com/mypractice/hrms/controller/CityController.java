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
import com.mypractice.hrms.model.CityMaster;
import com.mypractice.hrms.repository.CommonDropdown;
import com.mypractice.hrms.service.CityService;
import com.mypractice.hrms.service.StateService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hrms/api/")
public class CityController {
	@Autowired
	private CityService cityService;
	@Autowired
	private StateService stateService;
	@ApiOperation(value = "add new city Details.", notes = "Returns the  ResponseMessage  in body.")
	@PostMapping("citymst/savecity")
	public ResponseEntity<Object> saveCity(@RequestBody CityMaster cityMaster) {
		System.out.println("MYcityMaster====>"+cityMaster);
		CityMaster master = cityService.save(cityMaster);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cityID}")
				.buildAndExpand(master.getStateID()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation(value = "returns all city details.", notes = "Returns city the  ResponseMessage  in body.")
	@GetMapping("citymst/getAllCityDetails")
	public List<CityMaster> findAll(){
		List<CityMaster> lst = cityService.findAll();
		if(lst.isEmpty()) {
			throw new RuntimeException("No record found");
		}
		return lst;
	}
	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/citymst/{cityID}/city")
	public Resource<CityMaster> getCity(@PathVariable Integer cityID) {
		Optional<CityMaster> citymaster = cityService.findOne(cityID);
		if (!citymaster.isPresent()) {
			throw new RuntimeException("cityid is not found" + cityID);
		}
		Resource<CityMaster> cityResource= new Resource<CityMaster>(citymaster.get());
		ControllerLinkBuilder links= linkTo(methodOn(this.getClass()).getCityDetails());
		cityResource.add(links.withRel("all-city"));
		return cityResource;
	}
	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/citymaster/getCites")
	public List<CityMaster> getCityDetails() {
		System.out.println("CityMasterController.getCityDetails()");
		List<CityMaster> ctymst = cityService.getCityDetails();
		System.out.print(ctymst);
		if (ctymst.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found");
		}
		return ctymst;
	}
	@ApiOperation(value = "add new City Details.", notes = "Returns the  ResponseMessage  in body.")
	@DeleteMapping("/citymst/{cityId}/deletecity")
	public void deleteCity(@PathVariable("cityId") Integer cityId) {
		Optional<CityMaster> citymaster = cityService.findOne(cityId);
		if (!citymaster.isPresent()) {
			throw new RuntimeException("stateId is not found" + cityId);
		}
		CityMaster ctyMst = citymaster.get();
		cityService.deleteCity(ctyMst);
	}
	@ApiOperation(value = "a returns states.", notes = "Returns the  ResponseMessage  in body.")
	@GetMapping("/citymst/getstate")
	public List<CommonDropdown> findAllState(){
		List<CommonDropdown> sttmst = stateService.findAllStates();
		if (sttmst.isEmpty()) {
			throw new ResourceNotFoundException("Record Not Found");
		}
		return sttmst;
	}
}

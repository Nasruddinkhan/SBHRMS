 /**
 * 
 */
 package com.mypractice.hrms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypractice.hrms.bean.DropDownBean;
import com.mypractice.hrms.service.HRMSService;

/**
 * @author Nasruddin Khan 
 * 14-Sep-2019 - 1:43:14 pm
 * HRMSController.java
 */
@RestController
@RequestMapping("/hrms/api/")
public class HRMSController {
	@Autowired
	private HRMSService hrmsService;
	@GetMapping("hrms/onloadDropdowns")
	public Map<String, List<DropDownBean>> getDropDowns() {
		return hrmsService.getDropDowns();
	}
}

 

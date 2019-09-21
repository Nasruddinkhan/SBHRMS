 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;
import java.util.Map;

import com.mypractice.hrms.bean.DropDownBean;

/**
 * @author Nasruddin Khan 
 * 14-Sep-2019 - 1:51:55 pm
 * MenuAccessService.java
 */
public interface HRMSService {

	/**
	 * @return
	 */
	Map<String, List<DropDownBean>> getDropDowns();

}

 

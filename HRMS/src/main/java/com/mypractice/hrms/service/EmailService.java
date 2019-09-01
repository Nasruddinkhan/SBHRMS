 /**
 * 
 */
 package com.mypractice.hrms.service;

import java.util.List;

import com.mypractice.hrms.model.EmailHistory;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:44:39 pm
 * EmailService.java
 */
public interface EmailService {

	/**
	 * @param list
	 * @return
	 */
	List<Integer> sendMails(List<EmailHistory> list);

	/**
	 * @param lists
	 * @return
	 */
	Integer upDateEmailHistoryFlag(List<Integer> lists);

}

 

 /**
 * 
 */
 package com.mypractice.hrms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.mypractice.hrms.repository.EmailHistoryRepo;
import com.mypractice.hrms.util.CommonUtils;
import com.mypractice.hrms.util.EmailTaskService;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:38:08 pm
 * SchedulerConfig.java
 */
@Configuration
@EnableScheduling
public class SchedulerConfig {
	@Autowired
	private EmailTaskService emailTaskService;
	@Autowired
	EmailHistoryRepo emailRepo;
	@Scheduled(cron =CommonUtils.JOB_TIME)
	public void confiqureBulkMail() {
		emailTaskService.sendEmail(emailRepo.getTemplates());
	}
}

 

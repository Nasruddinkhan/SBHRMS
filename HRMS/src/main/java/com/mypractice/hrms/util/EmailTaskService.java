 /**
 * 
 */
 package com.mypractice.hrms.util;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mypractice.hrms.model.EmailHistory;
import com.mypractice.hrms.model.EmailTemplates;
import com.mypractice.hrms.repository.EmailHistoryRepo;
import com.mypractice.hrms.repository.EmailTemplatesRepo;
import com.mypractice.hrms.service.EmailService;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:40:15 pm
 * EmailTaskService.java
 */
@Component
public class EmailTaskService {
	@Autowired 
	private  EmailHistoryRepo emailHistoryRepo;
	
	@Autowired 
	private  EmailTemplatesRepo emailTemplatesRepo;

	@Autowired
	private EmailService emailService;
	public void sendEmail(List<EmailHistory> list) {
		Predicate<List<EmailHistory>> chkEmails = l -> l != null && l.size() > 0;
		Predicate<List<Integer>> mailList = l -> l != null && l.size() > 0;
		if(chkEmails.test(list)) {
			Runnable mailTriggerThread =()->{
				List<Integer> lists = emailService.sendMails(list);
				if(mailList.test(lists)) {
				Integer rowUpdate = emailService.upDateEmailHistoryFlag(lists);
				System.out.println("rowUpdate =>"+rowUpdate);
				}
			};
			Thread approval= new Thread(mailTriggerThread);
			approval.start();
		}
	}
	public  void createMailData(String emailObject, String userID, String toMail, String ccMail, String approverName, Integer templateID ) {
		// TODO Auto-generated method stub
		Optional<EmailTemplates> emailTemplate = emailTemplatesRepo.findById(templateID);
		if(!emailTemplate.isPresent())
			throw new RuntimeException("Template id is not found on template master table");
		EmailHistory emailHistory =  new EmailHistory();
		emailHistory.setActiveStatus(1);
		emailHistory.setCreatedBy(userID);
		emailHistory.setIsEmailSent("N");
		emailHistory.setEmailObject(emailObject);
		emailHistory.setEmailTemplates(emailTemplate.get());
		emailHistory.setEmailCc(ccMail);
		emailHistory.setApproverName(approverName);
		emailHistory.setEmailTo(toMail);
		emailHistoryRepo.save(emailHistory);
	}	
}

 

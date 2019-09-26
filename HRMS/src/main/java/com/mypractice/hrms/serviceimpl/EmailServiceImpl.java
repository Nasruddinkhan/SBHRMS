 /**
 * 
 */
 package com.mypractice.hrms.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.hrms.bean.MailModel;
import com.mypractice.hrms.model.EmailHistory;
import com.mypractice.hrms.repository.EmailHistoryRepo;
import com.mypractice.hrms.service.EmailService;
import com.mypractice.hrms.util.MailApiUtils;

/**
 * @author Nasruddin Khan 
 * 01-Sep-2019 - 1:46:18 pm
 * EmailServiceImpl.java
 */
@Service("emailService")
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailHistoryRepo emailHistoryRepo;
	@Autowired
	private MailApiUtils mailApiUils;
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> sendMails(List<EmailHistory> bulkemails) {
		// TODO Auto-generated method stub
		
		List<Integer> list= new ArrayList<>();
		bulkemails.forEach(obj->{
			System.out.println(obj);
			MailModel mailObject = new MailModel();
			try {
				Map<String, Object> map = new ObjectMapper().readValue(obj.getEmailObject(), Map.class) ;
				mailObject.setObj(map);
				mailObject.setCcMail(obj.getEmailCc());
				mailObject.setToMail(obj.getEmailTo());
				mailObject.setFromMail(obj.getEmailTemplates().getFromID());
				mailObject.setSubject(obj.getEmailTemplates().getSubjects());
				mailObject.setTemplate(obj.getEmailTemplates().getTemplateName());
				if(mailApiUils.sendEmail(mailObject)) 
					list.add(obj.getEmailHistory());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return list;

	}
	@Override
	public Integer upDateEmailHistoryFlag(List<Integer> lists) {
		// TODO Auto-generated method stub
		return emailHistoryRepo.upDateEmailHistoryFlag(lists, new Timestamp(System.currentTimeMillis()));
	}

}

 

 /**
 * 
 */
 package com.mypractice.hrms.util;

import java.io.File;
import java.io.StringWriter;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.mypractice.hrms.bean.MailModel;
import com.mypractice.hrms.bean.TestMail;

/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 11:55:31 pm
 * MailApiUtils.java
 */
@Component
public class MailApiUtils {
	private static final Logger logger = LoggerFactory.getLogger(MailApiUtils.class);
	@Autowired
	MailProperty mailProperty;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	VelocityEngine velocityEngine;
	/**
	 * this method help to send the mail
	 * 
	 * @param type
	 * @param obj
	 * @throws Exception 
	 */
	public boolean sendEmail(String type, MailModel obj) throws Exception {
		logger.info("enter sendEmail()");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		boolean isError = false;  
		try {
			System.out.println("mimeMessage ["+mimeMessage+"]");
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(obj.getSubject());
			mimeMessageHelper.setFrom(obj.getFromMail());
			mimeMessageHelper.setTo(obj.getToMail());
			//mimeMessageHelper.setValidateAddresses(validateAddresses);
			if(obj.getAttachment()!=null&&obj.getAttachment().length!=0){
			 for (File file : obj.getAttachment()) {
	                FileSystemResource fr = new FileSystemResource(file);
	                mimeMessageHelper.addAttachment(file.getName(), fr);
	            }
			}
			logger.info("calling geContentFromTemplate()");
			String template=geContentFromTemplate(type, obj);
			Optional.ofNullable(template).orElseThrow(() -> new Exception(
	                "Unsupported value :template data coming empty " + template));
			System.out.println("template ::::::::"+template);
			mimeMessageHelper.setText(template, true);
			logger.info("mail trigger is start");
			mailSender.send(mimeMessageHelper.getMimeMessage());
			logger.info("mail sent successfully");
			isError = true;
		} catch (MessagingException e) {
			logger.error("Mail not sent" + e);
		}
		return isError;
	}
	/**
	 * @param type
	 * @param obj
	 * @return
	 */
	private String geContentFromTemplate(String type, MailModel obj) {
		logger.info("processing geContentFromTemplate function ");
		try {
			//MailModel model = (MailModel) obj;
			logger.info("get template name ");
			String getTemplateName=MailProperty.TEMPLATES + MailProperty.SLASH + obj.getTemplateName()+MailProperty.VM ;
			Optional.ofNullable(getTemplateName).orElseThrow(() -> new RuntimeException(
	                "Unsupported value :getTemplateName coming null " + getTemplateName));
			Template t = velocityEngine
					.getTemplate(getTemplateName);
			StringWriter writer = new StringWriter();
			t.merge(setContext(type, obj.getObj()), writer);
			logger.info("start to write the mail template");
			String template = writer.toString();
			logger.info("end the writer process ");
			return template;
		} catch (Exception e) {
			logger.error("something went wrong" + e);
		}
		return null;

	}
	/**
	 * @param type
	 * @param obj
	 * @return
	 */
	private VelocityContext setContext(String type, Object obj) {
		// TODO Auto-generated method stub
		logger.info("start to setContext()");
		VelocityContext context = null;
		 switch(type) {
		  case MailProperty.TEST_EMAILTEMPLATE:
			  logger.info("inside mail blocking case");
			TestMail testMail=  (TestMail) obj;
			Optional.ofNullable(testMail).orElseThrow(()-> new RuntimeException("Test mail Object has been null "+testMail));
			context = setBlockingObj(testMail);
			break;
		};
		return context;
	}
	/**
	 * @param testMail
	 * @return
	 */
	private VelocityContext setBlockingObj(TestMail testMail) {
		// TODO Auto-generated method stub
		VelocityContext context = new VelocityContext();
		logger.info("start to set the blocking template data");
		context.put("name", testMail.getName());
		return context;
	}
}

 

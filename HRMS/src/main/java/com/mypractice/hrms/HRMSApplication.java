package com.mypractice.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mypractice.hrms.bean.MailModel;
import com.mypractice.hrms.bean.TestMail;
import com.mypractice.hrms.util.MailApiUtils;

/**
 * @author Nasruddin khan
 *
 */
@SpringBootApplication
public class HRMSApplication {
	
	@Autowired MailModel mailModel;
	@Autowired TestMail test;
	public static void main(String[] args) {
		SpringApplication.run(HRMSApplication.class, args);
	}
		@Bean
		CommandLineRunner lookup(MailApiUtils mail) {
		
			return args -> {
				//System.err.println(mail.sendEmail(MailProperty.TEST_EMAILTEMPLATE, mailModel));
			};
		}	
}

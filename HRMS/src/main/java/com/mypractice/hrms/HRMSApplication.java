package com.mypractice.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mypractice.hrms.repository.SkillElementRepo;
import com.mypractice.hrms.util.MailApiUtils;

/**
 * @author Nasruddin khan
 *
 */
@SpringBootApplication
public class HRMSApplication {
	
	@Autowired
	SkillElementRepo skillrepo;
	public static void main(String[] args) {
		SpringApplication.run(HRMSApplication.class, args);
	}
		@Bean
		CommandLineRunner lookup(MailApiUtils mail) {
			skillrepo.getSkillElementsDetails().forEach(obj->System.out.println(obj.toString()));
			return args -> {
				//System.err.println(mail.sendEmail(MailProperty.TEST_EMAILTEMPLATE, mailModel));
			};
		}	
}

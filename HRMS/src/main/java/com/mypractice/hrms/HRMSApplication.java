package com.mypractice.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mypractice.hrms.repository.EmailHistoryRepo;
import com.mypractice.hrms.util.MailApiUtils;
/**
 * @author Nasruddin khan
 *Test 123
 */
@SpringBootApplication
public class HRMSApplication {
	@Autowired
	EmailHistoryRepo emailRepo;
	public static void main(String[] args) {
		SpringApplication.run(HRMSApplication.class, args);
	}
		@Bean
		CommandLineRunner lookup(MailApiUtils mail) {
			return args -> {
				emailRepo.getTemplates().forEach(obj->{
					System.out.println(obj+ " \n "+obj.getEmailTemplates());
				});
			};
		}	
}

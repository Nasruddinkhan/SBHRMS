 /**
 * 
 */
 package com.mypractice.hrms.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.mypractice.hrms.util.MailProperty;

/**
 * @author Nasruddin Khan 
 * 29-May-2019 - 11:50:20 pm
 * MyConfig.java
 */
@Configuration
public class MyConfig {
	private static final Logger logger = LoggerFactory.getLogger(MyConfig.class);

	@Autowired
	MailProperty mailProperty;
	@Bean
	public JavaMailSender getMailSender() {
		logger.info("MyConfig.getMailSender()");
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties javaMailProperties = new Properties();
		logger.info(mailProperty.getHostKey()+" "+ mailProperty.getHostValue());
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put(mailProperty.getHostKey(), mailProperty.getHostValue());
		javaMailProperties.put("mail.smtp.auth", mailProperty.getAuth());
		javaMailProperties.put("mail.smtp.port", "587");
		javaMailProperties.put("mail.debug", true);
		javaMailProperties.put("mail.mime.charset", "UTF-8");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		mailSender.setJavaMailProperties(javaMailProperties);
		mailSender.setUsername(mailProperty.getUserName());
		mailSender.setPassword(mailProperty.getPassword());
		return mailSender;
	}

    @Bean
    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
    	logger.info("ApplicationConfiguration.getVelocityEngine()");
    	VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
        return velocityEngine;
    }
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);    
        return firewall;
    }
}

 

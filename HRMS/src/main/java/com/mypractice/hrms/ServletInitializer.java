package com.mypractice.hrms;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Nasruddin khan
 * ServletInitializer.java
 * Mar 11, 2019 6:49:22 PM
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HRMSApplication.class);
	}

}

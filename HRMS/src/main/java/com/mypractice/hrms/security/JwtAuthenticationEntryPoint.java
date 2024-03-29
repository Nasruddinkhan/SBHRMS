 /**
 * 
 */
 package com.mypractice.hrms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:14:03 am
 * JwtAuthenticationEntryPoint.java
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");
	}
}

 

 /**
 * 
 */
 package com.mypractice.hrms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:35:38 am
 * JwtSuccessHandler.java
 */
public class JwtSuccessHandler  implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("success fully login");
		
	}

}

 

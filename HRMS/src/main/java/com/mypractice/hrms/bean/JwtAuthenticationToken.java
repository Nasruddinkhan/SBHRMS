 /**
 * 
 */
 package com.mypractice.hrms.bean;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:18:05 am
 * JwtAuthenticationToken.java
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}

 

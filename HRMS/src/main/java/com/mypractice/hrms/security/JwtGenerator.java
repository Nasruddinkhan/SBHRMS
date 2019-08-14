 /**
 * 
 */
 package com.mypractice.hrms.security;

import org.springframework.stereotype.Component;
import com.mypractice.hrms.bean.LoginBO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:34:05 am
 * JwtGenerator.java
 */
 @Component
public class JwtGenerator {
	    public String generate(LoginBO loginBo) {
	        Claims claims = Jwts.claims()
	                .setSubject(loginBo.getUsername());
	        return Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, "hrms@practice")
	                .compact();
	    }
}

 

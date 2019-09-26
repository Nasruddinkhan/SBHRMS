 /**
 * 
 */
 package com.mypractice.hrms.security;


import org.springframework.stereotype.Component;

import com.mypractice.hrms.bean.LoginBO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Nasruddin Khan 
 * 10-Jun-2019 - 2:24:05 am
 * JwtValidator.java
 */
@Component
public class JwtValidator {
    private String secret = "HRMS@practice";
    public LoginBO validate(String token) {
    	LoginBO loginBo = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            loginBo = new LoginBO();
            loginBo.setUsername(body.getSubject());
            loginBo.setPassword(loginBo.getPassword());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return loginBo;
    }
}

 

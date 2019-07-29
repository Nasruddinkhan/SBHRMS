package com.mypractice.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Nasruddin khan
 * ResourceNotFoundException.java
 * Feb 28, 2019 4:56:05 PM
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String message){
    	super(message);
    }
}
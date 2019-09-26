package com.mypractice.hrms.exception;

/**
 * Nasruddin khan
 * ResourceNotFoundException.java
 * Feb 28, 2019 4:56:05 PM
 */
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String message){
    	super(message);
    }
}
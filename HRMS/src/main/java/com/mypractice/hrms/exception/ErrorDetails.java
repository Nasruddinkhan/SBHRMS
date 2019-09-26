package com.mypractice.hrms.exception;

import java.util.Date;

/**
 * Nasruddin khan
 * ErrorDetails.java
 * Feb 28, 2019 4:54:41 PM
 */
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}

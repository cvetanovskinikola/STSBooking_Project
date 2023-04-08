package com.getaway.weekend.app.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class AppException {
	
	private final String message;
	private final HttpStatus status;
	private final ZonedDateTime timestamp;
	
	
	public AppException(String message, HttpStatus status, ZonedDateTime timestamp) {
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
	
}

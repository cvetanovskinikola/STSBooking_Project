package com.getaway.weekend.app.exception;

import org.springframework.stereotype.Component;

@Component
public class TimeoutForCancelException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6087573581956301155L;

	public String error() {
		return "We are sorry, it is too late to cancel your reservation..You are still welcome to attend :)";
	}
	
}

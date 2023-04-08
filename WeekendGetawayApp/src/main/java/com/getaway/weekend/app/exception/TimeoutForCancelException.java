package com.getaway.weekend.app.exception;

public class TimeoutForCancelException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6087573581956301155L;

	public TimeoutForCancelException(String message) {
		super(message);
	}
	public TimeoutForCancelException(String message, Throwable t) {
		super(message,t);
	}
	
}

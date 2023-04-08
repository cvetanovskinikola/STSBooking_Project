package com.getaway.weekend.app.exception;

public class WrongInputInfoException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8040089723192777503L;

	public WrongInputInfoException(String message) {
		super(message);
	}
	public WrongInputInfoException(String message, Throwable t) {
		super(message,t);
	}
	
}

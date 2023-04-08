package com.getaway.weekend.app.exception;


public class InsufficientFundsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8383112049398824854L;

	public InsufficientFundsException(String message) {
		super(message);
	}
	public InsufficientFundsException(String message,Throwable t) {
		super(message,t);
	}
	
}

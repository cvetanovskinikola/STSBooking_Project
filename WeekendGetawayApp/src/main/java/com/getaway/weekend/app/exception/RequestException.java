package com.getaway.weekend.app.exception;

public class RequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -141376028672223492L;

	public RequestException(String message) {
		super(message);
	}
	
	public RequestException(String message,Throwable t) {
		super(message,t);
	}
	
}

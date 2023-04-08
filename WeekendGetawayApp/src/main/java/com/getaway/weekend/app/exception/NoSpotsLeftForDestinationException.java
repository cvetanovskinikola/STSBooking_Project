package com.getaway.weekend.app.exception;


public class NoSpotsLeftForDestinationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8059649035823357890L;

	public NoSpotsLeftForDestinationException(String message) {
		super(message);
	}
	public NoSpotsLeftForDestinationException(String message,Throwable t) {
		super(message,t);
	}
	
}

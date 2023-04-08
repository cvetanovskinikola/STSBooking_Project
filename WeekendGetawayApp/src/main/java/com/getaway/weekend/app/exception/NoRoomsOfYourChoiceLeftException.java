package com.getaway.weekend.app.exception;

public class NoRoomsOfYourChoiceLeftException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9075267090354197620L;

	public NoRoomsOfYourChoiceLeftException(String message) {
		super(message);
	}
	public NoRoomsOfYourChoiceLeftException(String message,Throwable t) {
		super(message,t);
	}
}

package com.getaway.weekend.app.exception;

import org.springframework.stereotype.Component;

@Component
public class NoSpotsLeftForDestinationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8059649035823357890L;

	public String error() {
		return "We are sorry,this destination is fully booked";
	}
	
}

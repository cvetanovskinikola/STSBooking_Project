package com.getaway.weekend.app.exception;

import org.springframework.stereotype.Component;

@Component
public class NoRoomsOfYourChoiceLeftException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9075267090354197620L;

public String error() {
		
		return "Sorry, the room type of your choice is fully sold out for this destination";
	}
}

package com.getaway.weekend.app.exception;

import org.springframework.stereotype.Component;

@Component

public class NotMetReservationRequirementsException extends RuntimeException {

	private static final long serialVersionUID = 7407325878833614802L;
	
	public String error() {
		return "Didn't meet the reservation requirements. You probably have a reseration already";
				
	}
}

package com.getaway.weekend.app.exception;

import org.springframework.stereotype.Component;

@Component
public class InsufficientFundsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8383112049398824854L;

	public String error() {
		return "We are sorry, we can't make the reservation..Insufficient funds";
	}
	
}

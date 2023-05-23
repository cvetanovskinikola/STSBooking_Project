package com.getaway.weekend.app.exception;

import org.springframework.stereotype.Component;

@Component
public class WrongInputInfoException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8040089723192777503L;

	public String error() {
		return "We couldn't register your account.Please make sure your name and last name contain at least 4 characters, you are over 18 years old,"
				+ "your password contains at least 7 characters, your credit card number and your email are valid.";
	}
	
}

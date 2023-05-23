package com.getaway.weekend.app.exception;

import org.springframework.stereotype.Component;

@Component
public class MoreGuestsNewException extends RuntimeException{
    
	private static final long serialVersionUID = 6223439866695078278L;

	public String error() {
		
		return "Sorry, you can't book a room with less beds than guests";
	}
}

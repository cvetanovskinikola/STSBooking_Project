package com.getaway.weekend.app.entity;

public enum HotelRating {

	ONE_STAR("*"),
    TWO_STARS("**"),
    THREE_STARS("***"),
    FOUR_STARS("****"),
    FIVE_STARS("*****");

	String rating;
	HotelRating(String rating) {
		this.rating=rating;
	}
	
}

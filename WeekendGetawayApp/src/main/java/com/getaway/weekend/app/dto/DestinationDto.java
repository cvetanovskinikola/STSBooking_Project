package com.getaway.weekend.app.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDto {

	private Long id;
	private String country;
	private String city;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateGoing;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateBack;
	private Double travel_price;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getTravel_price() {
		return travel_price;
	}
	public void setTravel_price(Double travel_price) {
		this.travel_price = travel_price;
	}
	public Date getDateGoing() {
		return dateGoing;
	}
	public void setDateGoing(Date dateGoing) {
		this.dateGoing = dateGoing;
	}
	public Date getDateBack() {
		return dateBack;
	}
	public void setDateBack(Date dateBack) {
		this.dateBack = dateBack;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
}

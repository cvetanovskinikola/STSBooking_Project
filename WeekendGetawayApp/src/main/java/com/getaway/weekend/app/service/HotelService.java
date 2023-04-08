package com.getaway.weekend.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getaway.weekend.app.entity.Hotel;
import com.getaway.weekend.app.repository.HotelRepo;
@Service
public class HotelService {
	
	@Autowired
	private HotelRepo hr;
	
	public List<Hotel> getAllHotels(){
		return hr.findAll();
	}
	public Hotel getHotelById(Long id) {
		return hr.findById(id).orElse(null);
	}
	public Hotel saveHotel(Hotel hotel) {
		return hr.save(hotel);
	}
	public void deleteHotel(Long id) {
		hr.deleteById(id);
	}

}

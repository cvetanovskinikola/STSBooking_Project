package com.getaway.weekend.app.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.getaway.weekend.app.dto.DestinationDto;
import com.getaway.weekend.app.entity.Destination;
import com.getaway.weekend.app.entity.Reservation;
import com.getaway.weekend.app.repository.DestinationRepo;
import com.getaway.weekend.app.repository.ReservationRepo;

@Service
@Transactional
public class DestinationService {

	@Autowired
	private DestinationRepo dr;
	
	
	
	
	public List<Destination> getAllDestinations(){
		return dr.findAll();
	}

	public Destination getDestinationById(Long id) {
		return dr.findById(id).orElse(null);
	}
	public Destination updateDest(Destination dest) {
		return dr.save(dest);
	}
	
	public void deleteDest(Long id) {
		 dr.deleteById(id);
	}
	
	
	public Destination saveDestination(DestinationDto dd) {
		Destination dest = new Destination();
		dest.setCity(dd.getCity());
		dest.setCountry(dd.getCountry());
		dest.setDateBack(dd.getDateBack());
		dest.setDateGoing(dd.getDateGoing());
		dest.setTravel_price(dd.getTravel_price());
		dest.setPassengers(0);
		dest.setMax_passengers(40);
		dr.save(dest);
		dd.setId(dest.getId());
		return dest;
	}
	
	public int getGuestsForDestById(Long id) {
		int total=0;
		for (Reservation res : dr.findById(id).get().getReservations()) {
			total+=res.getGuests();
		}
		return total;
	}
	
	
}

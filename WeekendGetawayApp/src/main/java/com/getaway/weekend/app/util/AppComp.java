package com.getaway.weekend.app.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.getaway.weekend.app.entity.Destination;
import com.getaway.weekend.app.entity.Reservation;
import com.getaway.weekend.app.service.DestinationService;
import com.getaway.weekend.app.service.HotelService;
import com.getaway.weekend.app.service.ReservationService;
import com.getaway.weekend.app.service.UserServiceImpl;

@Component
public class AppComp {

	@Autowired ReservationService rs;
	@Autowired DestinationService ds;
	@Autowired UserServiceImpl usi;
	@Autowired HotelService hr;
	
	@PreDestroy
	public void removeDestinations() {
		Date datenow = new Date();
		for (Destination dest : ds.getAllDestinations()) {
			if(datenow.getTime()>dest.getDateGoing().getTime()) {
				ds.deleteDest(dest.getId());
				for (Reservation res : dest.getReservations()) {
					rs.deleteRes(res.getId());
				}
			}
		}
	}
	
}

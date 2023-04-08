package com.getaway.weekend.app.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.getaway.weekend.app.dto.ReservationDto;
import com.getaway.weekend.app.entity.Destination;
import com.getaway.weekend.app.entity.Reservation;
import com.getaway.weekend.app.entity.User;
import com.getaway.weekend.app.exception.InsufficientFundsException;
import com.getaway.weekend.app.exception.NoRoomsOfYourChoiceLeftException;
import com.getaway.weekend.app.exception.NoSpotsLeftForDestinationException;
import com.getaway.weekend.app.exception.RequestException;
import com.getaway.weekend.app.exception.TimeoutForCancelException;
import com.getaway.weekend.app.repository.ReservationRepo;
import com.getaway.weekend.app.repository.UserRepo;

import lombok.SneakyThrows;

@Service
@Transactional
public class ReservationService {

	@Autowired
	private ReservationRepo resRepo;
	@Autowired
	private UserServiceImpl usi;
	@Autowired
	private DestinationService ds;
	@Autowired
	private UserRepo uRepo;
	@Autowired
	private HotelService hr;
	
	public List<Reservation> getAllReservations() {
		return resRepo.findAll();
	}
	public Set<Reservation> getAllReservationsForUser(Long id){
		User user = usi.getUserById(id);
		return user.getReservations();
	}
	
	
	public Reservation getReservationById(Long id) {
		return resRepo.findById(id).orElse(null);
	}
	@Transactional
	@SneakyThrows
	public Reservation saveReservation(Reservation res) {
		//Destination dest = ds.getDestinationById(id);
		User user = uRepo.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		res.setUser(user);
		Destination dest = res.getDestination();
		int rt = res.getRoomType();
		if(rt==1){
			res.setFinalPrice(dest.getTravel_price()+dest.getHotel().getSinglePrice());
		}
		else if(rt==2) {
			res.setFinalPrice(res.getGuests()*dest.getTravel_price()+dest.getHotel().getDoublePrice());
		}
		else if(rt==3) {
			res.setFinalPrice(res.getGuests()*dest.getTravel_price()+dest.getHotel().getTriplePrice());
		}
		else if(rt==4) {
			res.setFinalPrice(res.getGuests()*dest.getTravel_price()+dest.getHotel().getFamilyPrice());
		}
		if(dest.getPassengers()+res.getGuests()>45) {
			throw new NoSpotsLeftForDestinationException("We are sorry,this destination is fully booked");
		}
		if(user.getSufficient_funds()<res.getFinalPrice()) {
			throw new InsufficientFundsException("We are sorry, we can't make the reservation..Insufficient funds");
		}
		if(res.getGuests()==2) {
			if(res.getRoomType()==1) {
				throw new RequestException("Sorry, you can't book a room with less beds than guests");
				
			}
		}
		if(res.getGuests()==3) {
			if(res.getRoomType()==1 || res.getRoomType()==2) {
				throw new RequestException("Sorry, you can't book a room with less beds than guests");
			}
		}
		if(res.getGuests()>3 && res.getGuests()<6) {
			if(res.getRoomType()==1 || res.getRoomType()==2 || res.getRoomType()==3) {
				throw new RequestException("Sorry, you can't book a room with less beds than guests");
			}
		}
		if(res.getGuests()>5) {
			throw new RequestException("Sorry, you can't book a room with less beds than guests");
		}
		if(res.getRoomType()==1) {
			if(dest.getHotel().getSinglePersonRoom()==0) {
				throw new NoRoomsOfYourChoiceLeftException("We are sorry, we have no single rooms left for this destination");
			}
			else dest.getHotel().setSinglePersonRoom(dest.getHotel().getSinglePersonRoom()-1);
			hr.saveHotel(dest.getHotel());
		}
		if(res.getRoomType()==2) {
			if(dest.getHotel().getTwoPersonRoom()==0) {
				throw new NoRoomsOfYourChoiceLeftException("We are sorry, we have no two person rooms left for this destination");
			}
			else dest.getHotel().setTwoPersonRoom(dest.getHotel().getTwoPersonRoom()-1);
			hr.saveHotel(dest.getHotel());
		}
		if(res.getRoomType()==3) {
			if(dest.getHotel().getThreePersonRoom()==0) {
				throw new NoRoomsOfYourChoiceLeftException("We are sorry, we have no three person rooms left for this destination");
			}
			else dest.getHotel().setThreePersonRoom(dest.getHotel().getThreePersonRoom()-1);
			hr.saveHotel(dest.getHotel());
		}
		if(res.getRoomType()==4) {
			if(dest.getHotel().getFamilyRoom()==0) {
				throw new NoRoomsOfYourChoiceLeftException("We are sorry, we have no family rooms left for this destination");
			}
			else dest.getHotel().setFamilyRoom(dest.getHotel().getFamilyRoom()-1);
			hr.saveHotel(dest.getHotel());
		}
		//calcFinalPrice(res);
		//reservationRequirements(res);
		//res.getDestination().addReservation(res);
		resRepo.save(res);
		updateUsers(res);
		dest.addReservation(res);
		dest.setPassengers(dest.getPassengers()+res.getGuests());
		ds.updateDest(dest);
		return res;
	}
	

	

	public Reservation updateRes(Reservation res) {
		return resRepo.save(res);
	}
	public void updateUsers(Reservation res) {
		User user = uRepo.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//		res.getUser().addReservation(res);
//		res.getUser().setSufficient_funds(res.getUser().getSufficient_funds()-res.getFinalPrice());
//		usi.updateUserFunds(res.getUser());
		user.addReservation(res);
		user.setSufficient_funds(user.getSufficient_funds()-res.getFinalPrice());
		usi.updateUserFunds(user);
		User admin = usi.getUserById(3l);
		admin.setSufficient_funds(admin.getSufficient_funds()+res.getFinalPrice());
		usi.updateUserFunds(admin);
	}


	public void calcFinalPrice(Reservation res) {
		int rt = res.getRoomType();
		if(rt==1){
			res.setFinalPrice(res.getDestination().getTravel_price()+res.getDestination().getHotel().getSinglePrice());
		}
		else if(rt==2) {
			res.setFinalPrice(res.getDestination().getTravel_price()+res.getDestination().getHotel().getDoublePrice());
		}
		else if(rt==3) {
			res.setFinalPrice(res.getDestination().getTravel_price()+res.getDestination().getHotel().getTriplePrice());
		}
		else if(rt==4) {
			res.setFinalPrice(res.getDestination().getTravel_price()+res.getDestination().getHotel().getFamilyPrice());
		}
	}
	public String fetchRoomTypeToString(Reservation reservation) {
		switch (reservation.getRoomType()) {
		case 1: return "Room for one";
		case 2: return "Room for two";
		case 3: return "Room for three";
		case 4: return "Room for up to five";
		}
		return null;
	}

	public void reserveLogic(User user, Reservation res) throws Exception{
		res.getDestination().addReservation(res);
		user.addReservation(res);
		user.setSufficient_funds(user.getSufficient_funds()-res.getFinalPrice());
	}
	public static long getDifferenceDays(Date d1, Date d2) {
	    long diff = (d1.getTime()-d2.getTime())/86400000;
	    return Math.abs(diff);
	}

	@Transactional
	public void cancelReservation(Long id) {
		Reservation res;
		res=resRepo.findById(id).get();
		User user = uRepo.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		//LocalDateTime dateNow1 = LocalDateTime.now();
		Date dateNow = new Date();
		//dateNow = convertToDateViaInstant(dateNow1);
		
		if(getDifferenceDays(res.getDestination().getDateGoing(),dateNow)<=7){
			throw new TimeoutForCancelException("We are sorry, it is too late to cancel your reservation..You are still welcome to attend :)");
		}
		else if(getDifferenceDays(res.getDestination().getDateGoing(),dateNow)>7){
			user.removeReservation(res);
			user.setSufficient_funds(user.getSufficient_funds()+res.getFinalPrice());
			User admin = usi.getUserById(1l);
			admin.setSufficient_funds(admin.getSufficient_funds()-res.getFinalPrice());
			res.getDestination().setPassengers(res.getDestination().getPassengers()-res.getGuests());
			if(res.getRoomType()==1) {
			res.getDestination().getHotel().setSinglePersonRoom(res.getDestination().getHotel().getSinglePersonRoom()+1);
			}
			else if(res.getRoomType()==2) {
				res.getDestination().getHotel().setTwoPersonRoom(res.getDestination().getHotel().getTwoPersonRoom()+1);
			}
			else if(res.getRoomType()==3) {
				res.getDestination().getHotel().setThreePersonRoom(res.getDestination().getHotel().getThreePersonRoom()+1);
			}
			else if(res.getRoomType()==4) {
				res.getDestination().getHotel().setFamilyRoom(res.getDestination().getHotel().getFamilyRoom()+1);
			}
			ds.updateDest(res.getDestination());
			resRepo.deleteById(res.getId());
			usi.updateUserFunds(user);
			usi.updateUserFunds(admin);
	}
	}
	public void deleteRes(Long id) {
		resRepo.deleteById(id);
	}
}

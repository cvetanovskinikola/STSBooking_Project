package com.getaway.weekend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaway.weekend.app.entity.Reservation;
import com.getaway.weekend.app.entity.User;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long>{

	Reservation findByUser(User user);
}

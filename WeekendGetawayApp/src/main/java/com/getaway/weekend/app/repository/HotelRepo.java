package com.getaway.weekend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getaway.weekend.app.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long>{

}

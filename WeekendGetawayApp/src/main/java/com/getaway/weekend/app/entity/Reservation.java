package com.getaway.weekend.app.entity;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Min(value = 1)
	@Max(value = 5)
	private int guests;
	private int roomType;
	@ManyToOne
	@JoinColumn(name = "destination_id",nullable = false)
	private Destination destination;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	@JsonBackReference
	private User user;
	@Column(nullable = true)
	private Double finalPrice;
//	@Override
//	public int hashCode() {
//		return Objects.hash( guests, destination, id,finalPrice);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Reservation other = (Reservation) obj;
//		return 
//				 Objects.equals(destination, other.destination) && Objects.equals(id, other.id)
//				 && Objects.equals(guests, other.guests) && Objects.equals(finalPrice, other.finalPrice);
//	}
//	@Override
//	public String toString() {
//		return "Reservation [id=" + id + ", guests=" + guests + ", roomType=" + roomType +  ", user=" + user + ", finalPrice=" + finalPrice + "]";
//	}
	

	
	
}

	
	
	
	
	
	
	
	


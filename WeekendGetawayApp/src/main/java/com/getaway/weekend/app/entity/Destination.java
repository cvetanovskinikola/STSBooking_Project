package com.getaway.weekend.app.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "destinations")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	private String city;
	private Date dateGoing;
	private Date dateBack;
	@Column(name="travel_price")
	private Double travel_price;
	private int passengers;
	private int max_passengers;
	@OneToOne(orphanRemoval = true,cascade = CascadeType.PERSIST)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	@OneToMany(mappedBy = "destination",orphanRemoval = true,cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Reservation> reservations = new HashSet<>();
//	@OneToMany(mappedBy = "destination")
//	@JsonIgnore
//	private Set<User> users;
	public void addReservation(Reservation r) {
    	this.reservations.add(r);
    	r.setDestination(this);
    }
	public void removeReservation(Reservation r) {
    	r.setDestination(null);
    	reservations.remove(r);
    }
	

//	@Override
//	public int hashCode() {
//		return Objects.hash(city, country, dateBack, dateGoing, hotel, id, reservations, travel_price);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Destination other = (Destination) obj;
//		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
//				&& Objects.equals(dateBack, other.dateBack) && Objects.equals(dateGoing, other.dateGoing)
//				&& Objects.equals(hotel, other.hotel) && Objects.equals(id, other.id)
//				&& Objects.equals(reservations, other.reservations) && Objects.equals(travel_price, other.travel_price);
//	}

//	@Override
//	public String toString() {
//		return "Destination [id=" + id + ", country=" + country + ", city=" + city + ", dateGoing=" + dateGoing
//				+ ", dateBack=" + dateBack + ", travel_price=" + travel_price +  ", reservations="
//				+ reservations + "]";
//	}

	
	
	
	
	
	
	
	
}

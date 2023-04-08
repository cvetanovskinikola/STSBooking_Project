package com.getaway.weekend.app.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "hotel_name")
	private String hotel_name;
	@Enumerated(EnumType.STRING)
	@Column(name="hotel_rating")
	private HotelRating hotel_rating;
	private Integer singlePersonRoom;
	private Integer twoPersonRoom;
	private Integer threePersonRoom;
	private Integer familyRoom;
	private Double singlePrice;
	private Double doublePrice;
	private Double triplePrice;
	private Double familyPrice;
	private int roomType;
	@Column(name="hotel_link")
	private String hotel_link;
	@OneToOne(mappedBy = "hotel")
	private Destination destination;
//	@Override
//	public int hashCode() {
//		return Objects.hash(destination, doublePrice, familyPrice, familyRoom, hotel_link, hotel_name, hotel_rating, id,
//			/*	photo,*/ singlePersonRoom, singlePrice, threePersonRoom, triplePrice, twoPersonRoom);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Hotel other = (Hotel) obj;
//		return Objects.equals(destination, other.destination) && Objects.equals(doublePrice, other.doublePrice)
//				&& Objects.equals(familyPrice, other.familyPrice) && Objects.equals(familyRoom, other.familyRoom)
//				&& Objects.equals(hotel_link, other.hotel_link) && Objects.equals(hotel_name, other.hotel_name)
//				&& hotel_rating == other.hotel_rating && Objects.equals(id, other.id)
//				/*&& Objects.equals(photo, other.photo)*/ && Objects.equals(singlePersonRoom, other.singlePersonRoom)
//				&& Objects.equals(singlePrice, other.singlePrice)
//				&& Objects.equals(threePersonRoom, other.threePersonRoom)
//				&& Objects.equals(triplePrice, other.triplePrice) && Objects.equals(twoPersonRoom, other.twoPersonRoom);
//	}
//	@Override
//	public String toString() {
//		return "Hotel [id=" + id + ", hotel_name=" + hotel_name + ", hotel_rating=" + hotel_rating + ", photoPath=" + photoPath
//				+ ", singlePersonRoom=" + singlePersonRoom + ", twoPersonRoom=" + twoPersonRoom + ", threePersonRoom="
//				+ threePersonRoom + ", familyRoom=" + familyRoom + ", singlePrice=" + singlePrice + ", doublePrice="
//				+ doublePrice + ", triplePrice=" + triplePrice + ", familyPrice=" + familyPrice + ", hotel_link="
//				+ hotel_link +  "]";
//	}
	
	
	
	
}

package com.rupa.responce;

import java.sql.Blob;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor

public class RoomResponce {
	
	private Long id;
	private String roomType;
	private Double roomPrice;
	private boolean isBooked =false;
	private String  photo;
	 
	 private List<BookingResponce> bookings;

	public RoomResponce(Long id, String roomType, Double roomPrice) {
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
	}

	@SuppressWarnings("deprecation")
	public RoomResponce(Long id, String roomType, Double roomPrice, boolean isBooked, 
			byte[] photoBytes,
			List<BookingResponce> bookings) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.isBooked = isBooked;
		this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes):null;
		this.bookings = bookings;
		
	}


}
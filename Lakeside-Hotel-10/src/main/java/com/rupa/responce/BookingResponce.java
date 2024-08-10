package com.rupa.responce;

import java.time.LocalDate;

import com.rupa.model.Room;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponce {
	
private Long id;
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
	
	private String guestFullName;
	
	private String email;

	private int numOfAdults;
	
	private int numOfChildren;

	private int totalNumOfGuest;

	private String bookingConfirmationCode;
	
	private RoomResponce room;

	public BookingResponce(Long id, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfirmationCode) {
		//super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookingConfirmationCode = bookingConfirmationCode;
	}
	
	

	

}

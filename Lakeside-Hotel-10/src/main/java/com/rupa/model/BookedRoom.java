package com.rupa.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	@Column(name = "checkIn")
	private LocalDate checkInDate;

	@Column(name = "checkOut")
	private LocalDate checkOutDate;

	@Column(name = "guest_name")
	private String guestFullName;

	@Column(name = "guest_email")
	private String email;

	@Column(name = "adults")
	private int numOfAdults;

	@Column(name = "children")
	private int numOfChildren;

	@Column(name = "total_guest")
	private int totalNumOfGuest;

	@Column(name = "confirmationcode")
	private String bookingConfirmationCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;

	public void calculateTotalNoOfGuest() {

		this.totalNumOfGuest = this.numOfAdults + this.numOfChildren;
	}
	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
		calculateTotalNoOfGuest();
	}
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalNoOfGuest();
	}
	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}


}

package com.rupa.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rupa.exception.RetrivelPhotoException;
import com.rupa.model.BookedRoom;
import com.rupa.model.Room;
import com.rupa.responce.BookingResponce;
import com.rupa.responce.RoomResponce;
import com.rupa.service.BookingService;
import com.rupa.service.IRoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomCntroller {
	
	private final  IRoomService iRoomService;
	private final BookingService bookingService;
	
	@PostMapping("/add/new-room")
	public ResponseEntity<RoomResponce> addNewRoom(
		@RequestParam("photo")MultipartFile photo, 
		@RequestParam("roomType") String roomType, 
		@RequestParam("roomPrice")Double roomPrice  ) throws IOException, SQLException{
		
	Room savedRoom = iRoomService.addNewRoom(photo, roomType, roomPrice);
		RoomResponce response = new RoomResponce(savedRoom.getId(),savedRoom.getRoomType(),savedRoom.getRoomPrice());
	
	return ResponseEntity.ok(response);
	}
	
	private RoomResponce getRoomResponce (Room room) {
		List<BookedRoom> bookings = getAllBookingsByRoomId(room.getId());
			List<BookingResponce> bookingInfo = bookings
					.stream()
					. map(booking -> new BookingResponce(booking.getBookingId(),
						booking.getCheckInDate(),booking.getCheckOutDate(),
						booking.getBookingConfirmationCode())).toList();
			byte[] photoBytes =  null;
			Blob photoBlob = room.getPhoto();
			if(photoBlob != null) {
				try {
					photoBytes =photoBlob.getBytes(1, (int)photoBlob.length());
					
				}catch(SQLException e){
					throw new RetrivelPhotoException("Error retrieving the photo");
					
				}
			}
			return new RoomResponce(room.getId(),
					room.getRoomType(),
					room.getRoomPrice(),
					room.isBooked(),photoBytes,bookingInfo);
	}

	private List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
		// TODO Auto-generated method stub
		
		List<BookedRoom> allBookingsByRoomId = bookingService.getAllBookingsByRoomId(roomId);
		return allBookingsByRoomId;
	}
	
	@GetMapping("/room/types")
	public List<String> getRoomTypes(){
		return iRoomService.getAllRoomTypes();
		 
	}
			
}

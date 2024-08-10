package com.rupa.service;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rupa.model.Room;
import com.rupa.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements IRoomService {
	
	private final  RoomRepository roomRepository;
	@Override
	public Room addNewRoom(MultipartFile file, String roomType, Double roomPrice) throws IOException, SQLException, SQLException {
		Room room = new Room();
		room.setRoomType(roomType);
		room.setRoomPrice(roomPrice);
		if(!file.isEmpty()) {
			byte[] photoBytes = file.getBytes();
			Blob phtoBlob = new SerialBlob(photoBytes);
			room.setPhoto(phtoBlob);
		}
	
		
		return roomRepository.save(room);
	}
	@Override
	public List<String> getAllRoomTypes() {
		// TODO Auto-generated method stub
		return null;
	}

} 

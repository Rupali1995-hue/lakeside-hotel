package com.rupa.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rupa.model.Room;

public interface IRoomService {
	
	 Room addNewRoom(MultipartFile photo, String roomType, Double roomPrice) throws IOException, SQLException, SQLException;

	List<String> getAllRoomTypes();


}
 
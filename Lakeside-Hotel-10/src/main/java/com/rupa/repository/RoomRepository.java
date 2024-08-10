package com.rupa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rupa.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}

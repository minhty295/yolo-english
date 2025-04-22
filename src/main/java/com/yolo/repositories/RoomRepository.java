package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}

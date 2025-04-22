package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}

package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.TimeTable;

public interface TimeTableRespository extends JpaRepository<TimeTable, Integer>{

}

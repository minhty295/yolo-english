package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Level;

public interface LevelRepository extends JpaRepository<Level, Integer> {
	
}

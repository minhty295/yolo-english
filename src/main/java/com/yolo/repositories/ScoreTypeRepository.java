package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.ScoreType;

public interface ScoreTypeRepository extends JpaRepository<ScoreType, Integer> {

}

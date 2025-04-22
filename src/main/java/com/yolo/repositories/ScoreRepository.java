package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}

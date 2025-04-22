package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours,Integer> {

}

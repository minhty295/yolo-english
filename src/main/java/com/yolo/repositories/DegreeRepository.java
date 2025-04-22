package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {

}

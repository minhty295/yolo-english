package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}

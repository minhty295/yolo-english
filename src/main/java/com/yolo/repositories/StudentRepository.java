package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

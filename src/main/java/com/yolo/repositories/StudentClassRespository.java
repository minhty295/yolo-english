package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.StudentClass;

public interface StudentClassRespository extends JpaRepository<StudentClass, Integer> {

}

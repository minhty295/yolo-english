package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}

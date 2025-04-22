package com.yolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.entities.TeacherSalary;

public interface TeacherSalaryRepository extends JpaRepository<TeacherSalary, Integer> {

}

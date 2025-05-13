package com.yolo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yolo.entities.Student;
import com.yolo.responses.StudentRes;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	 public Student findByEmail(String email);
	 
	 @Query("SELECT new com.yolo.responses.StudentRes( " +
		       "s.id, " +
		       "s.address, " +
		       "s.birthday, " +
		       "s.email, " +
		       "s.fullName, " +
		       "s.gender, " +
		       "s.parentName, " +
		       "s.parentPhone, " +
		       "s.phone, " +
		       "s.relationship, " +
		       "s.status, " +
		       "s.studentCode, " +
		       "new com.yolo.responses.StudentRes$Level(s.level.id, s.level.name) " +
		       ") FROM Student s")
		Page<StudentRes> findAllStudents(Pageable pageable);

}

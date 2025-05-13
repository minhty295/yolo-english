package com.yolo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yolo.entities.Student;
import com.yolo.helpers.ApiResponse;
import com.yolo.helpers.QueryParams;
import com.yolo.responses.StudentRes;
import com.yolo.services.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping()
	public ResponseEntity<ApiResponse<Page<StudentRes>>> getAllStudent(@ModelAttribute QueryParams params){
		 return ResponseEntity.ok(studentService.getAllStudents(params));
	}
}

package com.yolo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yolo.entities.Student;
import com.yolo.helpers.ApiResponse;
import com.yolo.helpers.QueryParams;
import com.yolo.mappers.StudentMapper;
import com.yolo.repositories.StudentRepository;
import com.yolo.responses.StudentRes;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public ApiResponse<Page<StudentRes>> getAllStudents(QueryParams params) {
	    Sort sort = Sort.unsorted(); 

	    if (params.getSortBy() != null && !params.getSortBy().isBlank()) {
	        sort = Sort.by(params.getSortBy());
	        if ("desc".equalsIgnoreCase(params.getSortDirection())) {
	            sort = sort.descending();
	        } else {
	            sort = sort.ascending();
	        }
	    }

	    Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), sort);
	    Page<StudentRes> pageStudents = studentRepository.findAllStudents(pageable);

	    return new ApiResponse<>(200, "Thành công.", pageStudents);
	}

}

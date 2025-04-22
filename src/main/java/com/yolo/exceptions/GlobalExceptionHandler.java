package com.yolo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yolo.helpers.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiResponse<Object>> handleNotFoundException(NotFoundException ex) {
		return new ResponseEntity<>(new ApiResponse<>(404, ex.getMessage(), null), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiResponse<Object>> handleBadRequestException(NotFoundException ex) {
		return new ResponseEntity<>(new ApiResponse<>(400, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {
		return new ResponseEntity<>(new ApiResponse<>(500, "Lỗi hệ thống" ,null), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

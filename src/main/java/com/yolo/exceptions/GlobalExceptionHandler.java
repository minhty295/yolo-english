package com.yolo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	public ResponseEntity<ApiResponse<Object>> handleBadRequestException(BadRequestException ex) {
		return new ResponseEntity<>(new ApiResponse<>(400, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<ApiResponse<Object>> handlAuthException(AuthException ex) {
		return new ResponseEntity<>(new ApiResponse<>(401, ex.getMessage(), null), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		String errorMessage = getFirstValidationError(result);
		
		ApiResponse<String> response = new ApiResponse<String>(400, errorMessage, null);
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	private String getFirstValidationError(BindingResult result) {
		if (result.hasErrors()) {
			ObjectError error = result.getAllErrors().get(0); 
			return error.getDefaultMessage(); 
		}
		return "Unknown error";
	}
}

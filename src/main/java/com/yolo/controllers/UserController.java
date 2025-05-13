package com.yolo.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yolo.dto.UserLoginDto;
import com.yolo.helpers.ApiResponse;
import com.yolo.responses.UserTokenRes;
import com.yolo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<UserTokenRes>> login(@Valid @RequestBody UserLoginDto userDto) {
	    ApiResponse<UserTokenRes> response = userService.userLogin(userDto);
	    return ResponseEntity.ok(response);
	}

}

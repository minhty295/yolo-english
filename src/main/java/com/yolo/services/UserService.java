package com.yolo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yolo.dto.UserLoginDto;
import com.yolo.dto.UserLoginSuccessDto;
import com.yolo.entities.Admin;
import com.yolo.entities.Student;
import com.yolo.entities.Teacher;
import com.yolo.exceptions.BadRequestException;
import com.yolo.helpers.ApiResponse;
import com.yolo.repositories.AdminRepository;
import com.yolo.repositories.StudentRepository;
import com.yolo.repositories.TeacherRepository;
import com.yolo.responses.UserTokenRes;
import com.yolo.utils.JwtUtil;

@Service
public class UserService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	TeacherRepository teacherRepo;

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	JwtUtil jwt;

	public ApiResponse<UserTokenRes> userLogin(UserLoginDto userDto) {
		String email = userDto.getEmail();
		String password = userDto.getPassword();
		int role = userDto.getRole();
		
		UserLoginSuccessDto userSuccess = getUserLoginSuccess(email, password, role);
		
		if(userSuccess == null) {
			throw new BadRequestException("Tên đăng nhập hoặc mật khẩu sai.");
		}
		
		String assetToken = jwt.generateAccessToken(email, String.valueOf(role));
		String refeshToken = jwt.generateAccessToken(email, String.valueOf(role));
		UserTokenRes response = new UserTokenRes(email, String.valueOf(role), assetToken, refeshToken);
		
		return new ApiResponse<UserTokenRes>(200, "Thành công.", response);
	}

	private UserLoginSuccessDto getUserLoginSuccess(String email, String password, int role) {

		if (role == 0) {
			Admin admin = adminRepo.findByEmail(email);

			if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
				return new UserLoginSuccessDto(email, "0");
			}

			return null;
		} else if (role == 1) {
			Teacher teacher = teacherRepo.findByEmail(email);

			if (teacher != null && passwordEncoder.matches(password, teacher.getPassword())) {
				return new UserLoginSuccessDto(email, "1");
			}

			return null;
		} else if (role == 2) {
			Student student = studentRepo.findByEmail(email);

			if (student != null && passwordEncoder.matches(password, student.getPassword())) {
				return new UserLoginSuccessDto(email, "2");
			}

			return null;
		}

		return null;
	}
}

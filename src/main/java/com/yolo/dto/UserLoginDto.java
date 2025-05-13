package com.yolo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserLoginDto {

    @Email(message = "Email không đúng định dạng.")
    @NotBlank(message = "Email không được để trống.")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống.") 
    @Size(min = 6, message = "Mật khẩu dài tối thiểu 6 ký tự.")
    private String password;

    @NotNull(message = "Quyền không được để trống.")
    private Integer role;

    // Constructors
    public UserLoginDto() {
    }

    public UserLoginDto(String email, String password, Integer role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}

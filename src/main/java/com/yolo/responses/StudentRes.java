package com.yolo.responses;

import java.time.LocalDate;

public class StudentRes {
    private Long id;
    private String address;
    private LocalDate birthday;
    private String email;
    private String fullName;
    private String gender;
    private String parentName;
    private String parentPhone;
    private String phone;
    private String relationship;
    private int status;
    private String studentCode;
    private StudentLevelRes level;

    // ✅ Constructor bắt buộc:
    public StudentRes(Long id, String address, LocalDate birthday, String email,
                      String fullName, String gender, String parentName, String parentPhone,
                      String phone, String relationship, int status, String studentCode,
                      StudentLevelRes level) {
        this.id = id;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
        this.phone = phone;
        this.relationship = relationship;
        this.status = status;
        this.studentCode = studentCode;
        this.level = level;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public StudentLevelRes getLevel() {
		return level;
	}

	public void setLevel(StudentLevelRes level) {
		this.level = level;
	}

	

  
}

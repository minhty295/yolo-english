package com.yolo.responses;


public class StudentRes {
    private Integer id;
    private String address;
    private String birthday;
    private String email;
    private String fullName;
    private Integer gender;
    private String parentName;
    private String parentPhone;
    private String phone;
    private String relationship;
    private Integer status;
    private String studentCode;
    private Level level;
    
    
    public StudentRes() {
		super();
	}

    public StudentRes(Integer id, String address, String birthday, String email, String fullName, Integer gender,
			String parentName, String parentPhone, String phone, String relationship, Integer status,
			String studentCode, Level level) {
		super();
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}




	public static class Level {
        private Integer id;
        private String name;
        
		public Level() {
			super();
		}
		
		public Level(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
       		
        
    }
}


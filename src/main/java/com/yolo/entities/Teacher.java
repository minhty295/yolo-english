package com.yolo.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the teachers database table.
 * 
 */
@Entity
@Table(name="teachers")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String address;

	private String avatar;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String cccd;

	private String email;

	@Column(name="experience_years")
	private int experienceYears;

	private String expertise;

	@Column(name="full_name")
	private String fullName;

	private byte gender;

	private String password;

	private String phone;

	private byte status;

	@Column(name="teacher_code")
	private String teacherCode;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="teacher")
	private List<ClassStudy> classes;

	//bi-directional many-to-one association to TeacherSalary
	@OneToMany(mappedBy="teacher")
	private List<TeacherSalary> teacherSalaries;

	//bi-directional many-to-one association to Degree
	@ManyToOne
	private Degree degree;

	//bi-directional many-to-one association to TimeTable
	@OneToMany(mappedBy="teacher")
	private List<TimeTable> timeTables;

	public Teacher() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCccd() {
		return this.cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExperienceYears() {
		return this.experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getExpertise() {
		return this.expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getTeacherCode() {
		return this.teacherCode;
	}

	public void setTeacherCode(String teacherCode) {
		this.teacherCode = teacherCode;
	}


	public List<ClassStudy> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassStudy> classes) {
		this.classes = classes;
	}

	public List<TeacherSalary> getTeacherSalaries() {
		return this.teacherSalaries;
	}

	public void setTeacherSalaries(List<TeacherSalary> teacherSalaries) {
		this.teacherSalaries = teacherSalaries;
	}

	public TeacherSalary addTeacherSalary(TeacherSalary teacherSalary) {
		getTeacherSalaries().add(teacherSalary);
		teacherSalary.setTeacher(this);

		return teacherSalary;
	}

	public TeacherSalary removeTeacherSalary(TeacherSalary teacherSalary) {
		getTeacherSalaries().remove(teacherSalary);
		teacherSalary.setTeacher(null);

		return teacherSalary;
	}

	public Degree getDegree() {
		return this.degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public List<TimeTable> getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(List<TimeTable> timeTables) {
		this.timeTables = timeTables;
	}

	public TimeTable addTimeTable(TimeTable timeTable) {
		getTimeTables().add(timeTable);
		timeTable.setTeacher(this);

		return timeTable;
	}

	public TimeTable removeTimeTable(TimeTable timeTable) {
		getTimeTables().remove(timeTable);
		timeTable.setTeacher(null);

		return timeTable;
	}

}
package com.yolo.entities;
import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;

/**
 * The persistent class for the teacher_salaries database table.
 * 
 */
@Entity
@Table(name="teacher_salaries")
@NamedQuery(name="TeacherSalary.findAll", query="SELECT t FROM TeacherSalary t")
public class TeacherSalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="base_salary")
	private BigDecimal baseSalary;

	private int month;

	private int year;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	private Teacher teacher;

	public TeacherSalary() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getBaseSalary() {
		return this.baseSalary;
	}

	public void setBaseSalary(BigDecimal baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
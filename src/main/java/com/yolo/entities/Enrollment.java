package com.yolo.entities;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;


/**
 * The persistent class for the enrollments database table.
 * 
 */
@Entity
@Table(name="enrollments")
@NamedQuery(name="Enrollment.findAll", query="SELECT e FROM Enrollment e")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="enrollment_date")
	private Date enrollmentDate;

	private byte status;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="course_id")
	private Cours cours;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public Enrollment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEnrollmentDate() {
		return this.enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
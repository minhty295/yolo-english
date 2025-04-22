package com.yolo.entities;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the student_classes database table.
 * 
 */
@Entity
@Table(name="student_classes")
@NamedQuery(name="StudentClass.findAll", query="SELECT s FROM StudentClass s")
public class StudentClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Attendance
	@OneToMany(mappedBy="studentClass")
	private List<Attendance> attendances;

	//bi-directional many-to-one association to Score
	@OneToMany(mappedBy="studentClass")
	private List<Score> scores;

	//bi-directional many-to-one association to Class
	@ManyToOne
	private ClassStudy classStudy;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public StudentClass() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Attendance> getAttendances() {
		return this.attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Attendance addAttendance(Attendance attendance) {
		getAttendances().add(attendance);
		attendance.setStudentClass(this);

		return attendance;
	}

	public Attendance removeAttendance(Attendance attendance) {
		getAttendances().remove(attendance);
		attendance.setStudentClass(null);

		return attendance;
	}

	public List<Score> getScores() {
		return this.scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Score addScore(Score score) {
		getScores().add(score);
		score.setStudentClass(this);

		return score;
	}

	public Score removeScore(Score score) {
		getScores().remove(score);
		score.setStudentClass(null);

		return score;
	}

	public ClassStudy getClassStudy() {
		return classStudy;
	}

	public void setClassStudy(ClassStudy classStudy) {
		this.classStudy = classStudy;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
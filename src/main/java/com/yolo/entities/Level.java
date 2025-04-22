package com.yolo.entities;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the levels database table.
 * 
 */
@Entity
@Table(name="levels")
@NamedQuery(name="Level.findAll", query="SELECT l FROM Level l")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="level")
	private List<Student> students;

	public Level() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setLevel(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setLevel(null);

		return student;
	}

}
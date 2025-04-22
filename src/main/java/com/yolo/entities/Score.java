package com.yolo.entities;
import java.io.Serializable;

import jakarta.persistence.*;


/**
 * The persistent class for the scores database table.
 * 
 */
@Entity
@Table(name="scores")
@NamedQuery(name="Score.findAll", query="SELECT s FROM Score s")
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private float score;

	//bi-directional many-to-one association to ScoreType
	@ManyToOne
	@JoinColumn(name="score_type_id")
	private ScoreType scoreType;

	//bi-directional many-to-one association to StudentClass
	@ManyToOne
	@JoinColumn(name="student_class_id")
	private StudentClass studentClass;

	public Score() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public ScoreType getScoreType() {
		return this.scoreType;
	}

	public void setScoreType(ScoreType scoreType) {
		this.scoreType = scoreType;
	}

	public StudentClass getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(StudentClass studentClass) {
		this.studentClass = studentClass;
	}

}
package com.yolo.entities;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

/**
 * The persistent class for the time_table database table.
 * 
 */
@Entity
@Table(name="time_table")
@NamedQuery(name="TimeTable.findAll", query="SELECT t FROM TimeTable t")
public class TimeTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_time")
	private Date endTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;

	@Temporal(TemporalType.DATE)
	@Column(name="study_date")
	private Date studyDate;

	@Column(name="teacher_name")
	private String teacherName;

	//bi-directional many-to-one association to Class
	@ManyToOne
	private ClassStudy classStudy;

	//bi-directional many-to-one association to Room
	@ManyToOne
	private Room room;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	private Teacher teacher;

	public TimeTable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStudyDate() {
		return this.studyDate;
	}

	public void setStudyDate(Date studyDate) {
		this.studyDate = studyDate;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public ClassStudy getClassStudy() {
		return classStudy;
	}

	public void setClassStudy(ClassStudy classStudy) {
		this.classStudy = classStudy;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
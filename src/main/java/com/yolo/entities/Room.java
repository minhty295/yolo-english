package com.yolo.entities;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the rooms database table.
 * 
 */
@Entity
@Table(name="rooms")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to TimeTable
	@OneToMany(mappedBy="room")
	private List<TimeTable> timeTables;

	public Room() {
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

	public List<TimeTable> getTimeTables() {
		return this.timeTables;
	}

	public void setTimeTables(List<TimeTable> timeTables) {
		this.timeTables = timeTables;
	}

	public TimeTable addTimeTable(TimeTable timeTable) {
		getTimeTables().add(timeTable);
		timeTable.setRoom(this);

		return timeTable;
	}

	public TimeTable removeTimeTable(TimeTable timeTable) {
		getTimeTables().remove(timeTable);
		timeTable.setRoom(null);

		return timeTable;
	}

}
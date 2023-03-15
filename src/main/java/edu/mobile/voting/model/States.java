package edu.mobile.voting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class States {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "states", nullable = false)
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}
	
}

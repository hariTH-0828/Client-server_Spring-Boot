package edu.mobile.voting.model;

import jakarta.persistence.*;

@Entity
@Table(name = "States")
public class States {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "state", nullable = false)
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

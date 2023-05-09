package edu.mobile.voting.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PastPerformance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "PositionHeld", nullable = false)
	private String positionHeld;

	@Column(name = "NumberOfVote", nullable = false)
	private int numberOfVote;

	public String getPositionHeld() {
		return positionHeld;
	}

	public void setPositionHeld(String positionHeld) {
		this.positionHeld = positionHeld;
	}

	public int getNumberOfVote() {
		return numberOfVote;
	}

	public void setNumberOfVote(int numberOfVote) {
		this.numberOfVote = numberOfVote;
	}

	public int getId() {
		return id;
	}

}

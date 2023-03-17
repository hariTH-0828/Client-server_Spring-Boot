package edu.mobile.voting.model;

import jakarta.persistence.*;

@Entity
public class District {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "state_id", nullable = false)
	private int stateId;
	
	@Column(name = "district_name", nullable = false)
	private String district;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getId() {
		return id;
	}

}

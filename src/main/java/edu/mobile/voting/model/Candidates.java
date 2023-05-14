package edu.mobile.voting.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Candidates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Candidate_name", nullable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_candidateImage_id", referencedColumnName = "id")
	private DataFileInfo candidateImageId;

	@Column(name = "Candidate_party_name", nullable = false)
	private String partyName;

	@Column(name = "Candidate_qualification", nullable = false)
	private String qualification;

	@Column(name = "Average_rating", nullable = false)
	private float averageRating;

	@Column(name = "Candidate_age", nullable = false)
	private int age;

	@Column(name = "Candidate_gender", nullable = false)
	private String gender;

	@Column(name = "District", nullable = false)
	private int districtId;
	
	@Column(name = "State", nullable = false)
	private int stateId;
	
	@Column(name = "Aadhaar_number", nullable = false, unique = true)
	private String aadhaarNumber;

	@Column(name = "Candidate_Biography", nullable = false)
	private String background;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_contact_id", referencedColumnName = "id")
	private Contact contact;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_promises_id", referencedColumnName = "id")
	private List<Promises> promises;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_previousResult_id", referencedColumnName = "id")
	private PastPerformance pastPerformance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public DataFileInfo getCandidateImageId() {
		return candidateImageId;
	}

	public void setCandidateImageId(DataFileInfo candidateImageId) {
		this.candidateImageId = candidateImageId;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public List<Promises> getPromises() {
		return promises;
	}

	public void setPromises(List<Promises> promises) {
		this.promises = promises;
	}

	public PastPerformance getPastPerformance() {
		return pastPerformance;
	}

	public void setPastPerformance(PastPerformance pastPerformance) {
		this.pastPerformance = pastPerformance;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public int getId() {
		return id;
	}
}

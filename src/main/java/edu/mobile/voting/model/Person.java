package edu.mobile.voting.model;

import jakarta.persistence.Entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id", referencedColumnName = "id")
	private DataFileInfo profilePhoto;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "sex", nullable = false)
    private String gender;
    
    @Column(name = "date_of_bith", nullable = false)
    private Date dateOfBirth;
    
    @Column(name = "age", nullable = false)
    private int age;
    
    @Column(name = "father_name", nullable = false)
    private String fatherName;
    
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

	@Column(name = "aadhaar_number", nullable = false, unique = true)
    private String aadhaarNumber;
	
	@Column(name = "state_id", nullable = false)
	private int stateId;
	
	@Column(name = "district_id", nullable = false)
	private int districtId;
	
	@Column(name = "assembly_id", nullable = false)
	private int assemblyId;
	
	@Column(name = "voterNumber", nullable = false, unique = true)
	private String epicNumber;
	

	// Getter and Setter
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	 public int getAge() {
			return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}
	
	public int getAssemblyId() {
		return assemblyId;
	}

	public void setAssemblyId(int assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getEpicNumber() {
		return epicNumber;
	}

	public void setEpicNumber(String epicNumber) {
		this.epicNumber = epicNumber;
	}

	public int getId() {
		return id;
	}

	public DataFileInfo getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(DataFileInfo profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

}

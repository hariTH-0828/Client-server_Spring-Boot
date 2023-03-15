package edu.mobile.voting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "father_name", nullable = false)
    private String fatherName;
    
    @Column(name = "age", nullable = false)
    private int age;
    
    @Column(name = "sex", nullable = false)
    private String gender;
    
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

	@Column(name = "aadhaar_number", nullable = false)
    private String aadhaarNumber;
	
	
	
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

	public int getId() {
		return id;
	}
}

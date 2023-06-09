package edu.mobile.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	Person findByPhoneNumber(String phoneNumber);
	Person findByAadhaarNumber(String aadhaarNumber);
	Person findByEpicNumber(String epicNumber);
}

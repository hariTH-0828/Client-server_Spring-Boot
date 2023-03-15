package edu.mobile.voting.service;

import java.util.List;

import edu.mobile.voting.model.Person;

public interface PersonService {
	Person savePerson(Person person);
	List<Person> getAllPersons();
	Person getPersonById(int id);
	Person updatePersonById(Person person, int id);
	void deletePersonById(int id);
}

package edu.mobile.voting.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mobile.voting.model.Person;
import edu.mobile.voting.repository.PersonRepository;
import edu.mobile.voting.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	private PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
}

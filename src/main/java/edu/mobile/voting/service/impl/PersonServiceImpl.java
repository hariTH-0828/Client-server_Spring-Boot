package edu.mobile.voting.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mobile.voting.exception.ResourceNotFound;
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

	@Override
	public Person getPersonById(int id) {
		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Person", "id", id));
	}

	@Override
	public Person updatePersonById(Person person, int id) {
		Person existPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Person", "Person not exist", id));
		existPerson.setName(person.getName());
		existPerson.setFatherName(person.getFatherName());
		existPerson.setAge(person.getAge());
		existPerson.setGender(person.getGender());
		existPerson.setPhoneNumber(person.getPhoneNumber());
		existPerson.setAadhaarNumber(person.getAadhaarNumber());
		
		personRepository.save(existPerson);
		return existPerson;
	}

	@Override
	public void deletePersonById(int id) {
		personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Person", "id", id));
		personRepository.deleteById(id);
	}
}

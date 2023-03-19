package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.exception.ResourceNotFound;
import edu.mobile.voting.model.Person;
import edu.mobile.voting.repository.PersonRepository;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@PostMapping("/setPerson")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(personRepository.save(person), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
		return new ResponseEntity<Person>(personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Person", "id", id)), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Person> updatePersonById(@PathVariable("id") int id, @RequestBody Person person){
		Person existPerson = personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Person", "id", id));
		existPerson.setName(person.getName());
		existPerson.setFatherName(person.getFatherName());
		existPerson.setAge(person.getAge());
		existPerson.setGender(person.getGender());
		existPerson.setPhoneNumber(person.getPhoneNumber());
		existPerson.setAadhaarNumber(person.getAadhaarNumber());
		existPerson.setStateId(person.getStateId());
		
		personRepository.save(existPerson);
		return new ResponseEntity<Person>(existPerson, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable("id") int id) {
		personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Person", "id", id));
		personRepository.deleteById(id);
		return new ResponseEntity<String>("Person Deleted Successfully...", HttpStatus.OK);
	}
}

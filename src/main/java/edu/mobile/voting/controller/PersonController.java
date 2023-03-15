package edu.mobile.voting.controller;

import java.util.List;

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

import edu.mobile.voting.model.Person;
import edu.mobile.voting.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	private PersonService personService;
	
	 public PersonController(PersonService personService) {
		 super();
		 this.personService = personService; 
	 }
	
	@PostMapping("/setPerson")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") int id) {
		return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Person> updatePersonById(@PathVariable("id") int id, @RequestBody Person person){
		return new ResponseEntity<Person>(personService.updatePersonById(person, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable("id") int id) {
		personService.deletePersonById(id);
		return new ResponseEntity<String>("Person Deleted Successfully...", HttpStatus.OK);
	}
}

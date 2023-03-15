package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.Person;
import edu.mobile.voting.service.PersonService;

@RestController
@RequestMapping("/api")
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
}

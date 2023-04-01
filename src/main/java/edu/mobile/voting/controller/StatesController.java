package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.States;
import edu.mobile.voting.repository.StatesRepository;

@RestController
@RequestMapping("/api/states")
public class StatesController {

	@Autowired
	private StatesRepository statesRepository;
	
	@GetMapping("/getAll")
	public List<States> getAllStates(States states){
		return statesRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<String> getStatesById(@PathVariable("id") int id) {
		return new ResponseEntity<String>(statesRepository.findById(id).get().getState(), HttpStatus.OK);
	}
	
	
	@GetMapping("/search/{stateName}") 
	public int getStateIdByName(@PathVariable("stateName") String stateName) { 
		return statesRepository.findByState(stateName).getId(); 
	}

}

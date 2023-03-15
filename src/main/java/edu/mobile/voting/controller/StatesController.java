package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.States;
import edu.mobile.voting.service.StatesService;

@RestController
@RequestMapping("/api/states")
public class StatesController {

	private StatesService statesService;

	public StatesController(StatesService statesService) {
		super();
		this.statesService = statesService;
	}
	
	@PostMapping("/setStates")
	public ResponseEntity<States> saveStates(@RequestBody States states) {
		return new ResponseEntity<States>(statesService.saveStates(states), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public List<States> getAllStates(States states){
		return statesService.getAllStates(states);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<States> getStatesById(@PathVariable("id") int id) {
		return new ResponseEntity<States>(statesService.getStatesById(id), HttpStatus.OK);
	}
}

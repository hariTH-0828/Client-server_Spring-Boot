package edu.mobile.voting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.States;
import edu.mobile.voting.service.StatesService;

@RestController
@RequestMapping("/save_states")
public class StatesController {

	private StatesService statesService;

	public StatesController(StatesService statesService) {
		super();
		this.statesService = statesService;
	}
	
	@PostMapping()
	public ResponseEntity<States> saveStates(@RequestBody States states) {
		return new ResponseEntity<States>(statesService.saveStates(states), HttpStatus.CREATED);
	}
}

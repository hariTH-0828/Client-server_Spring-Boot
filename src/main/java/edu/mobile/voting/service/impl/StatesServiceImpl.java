package edu.mobile.voting.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mobile.voting.exception.ResourceNotFound;
import edu.mobile.voting.model.States;
import edu.mobile.voting.repository.StatesRepository;
import edu.mobile.voting.service.StatesService;

@Service
public class StatesServiceImpl implements StatesService{
	
	private StatesRepository statesRepository;

	public StatesServiceImpl(StatesRepository statesRepository) {
		super();
		this.statesRepository = statesRepository;
	}

	@Override
	public States saveStates(States states) {
		return statesRepository.save(states);
	}

	@Override
	public List<States> getAllStates(States states) {
		return statesRepository.findAll();
	}

	@Override
	public States getStatesById(int id) {
		return statesRepository.findById(id).orElseThrow(() -> new ResourceNotFound("states", "id", id));
	}

	@Override
	public int getStateIdByName(String stateName) {
		return statesRepository.findByState(stateName).getId();
	}
}

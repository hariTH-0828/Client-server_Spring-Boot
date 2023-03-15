package edu.mobile.voting.service.impl;

import org.springframework.stereotype.Service;

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

	

}

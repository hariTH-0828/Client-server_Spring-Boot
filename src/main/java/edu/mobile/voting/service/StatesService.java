package edu.mobile.voting.service;

import java.util.List;

import edu.mobile.voting.model.States;

public interface StatesService {
	States saveStates(States states);
	List<States> getAllStates(States states);
	States getStatesById(int id);
}

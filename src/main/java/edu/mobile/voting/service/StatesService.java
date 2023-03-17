package edu.mobile.voting.service;

import java.util.List;

import edu.mobile.voting.model.States;

public interface StatesService {
	List<States> getAllStates(States states);
	States getStatesById(int id);
	int getStateIdByName(String stateName);
}

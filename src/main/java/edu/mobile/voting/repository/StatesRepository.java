package edu.mobile.voting.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.States;

public interface StatesRepository extends JpaRepository<States, Integer> {
	States findByState(String stateName);
}

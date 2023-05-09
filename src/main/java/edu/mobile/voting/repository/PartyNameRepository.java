package edu.mobile.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.PoliticalParties;

public interface PartyNameRepository extends JpaRepository<PoliticalParties, Integer> {

}

package edu.mobile.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.PastPerformance;

public interface ElectionResultRepository extends JpaRepository<PastPerformance, Integer> {

}

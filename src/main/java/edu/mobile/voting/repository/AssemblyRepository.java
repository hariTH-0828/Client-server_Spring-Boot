package edu.mobile.voting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.AssemblyConstituency;

public interface AssemblyRepository extends JpaRepository<AssemblyConstituency, Integer>{
	List<AssemblyConstituency> findByDistrictId(int district_id);
}

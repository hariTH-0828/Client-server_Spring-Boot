package edu.mobile.voting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.District;

public interface DistrictRepository extends JpaRepository<District, Integer>{
	District findByDistrict(String districtName);
	List<District> findByStateId(int stateId);
}

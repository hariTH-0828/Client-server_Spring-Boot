package edu.mobile.voting.service;

import java.util.List;

import edu.mobile.voting.model.District;

public interface DistrictService {
	District saveDistrict(District district);
	List<District> getAllDistrict(District district);
	List<District> getDistrictByStataId(int stateId);
	District getDistrictById(int id);
	int getDistrictIdByName(String districtName);
}

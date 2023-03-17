package edu.mobile.voting.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mobile.voting.exception.ResourceNotFound;
import edu.mobile.voting.model.District;
import edu.mobile.voting.repository.DistrictRepository;
import edu.mobile.voting.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {
	
	public DistrictServiceImpl(DistrictRepository districtRepository) {
		super();
		this.districtRepository = districtRepository;
	}

	private DistrictRepository districtRepository;

	@Override
	public List<District> getAllDistrict(District district) {
		return districtRepository.findAll();
	}

	@Override
	public District getDistrictById(int id) {
		return districtRepository.findById(id).orElseThrow(() -> new ResourceNotFound("District", "id", id));
	}

	@Override
	public int getDistrictIdByName(String districtName) {
		return districtRepository.findByDistrict(districtName).getId();
	}

	@Override
	public District saveDistrict(District district) {
		return districtRepository.save(district);
	}

	@Override
	public List<District> getDistrictByStataId(int stateId) {
		return districtRepository.findByStateId(stateId);
	}
	
}

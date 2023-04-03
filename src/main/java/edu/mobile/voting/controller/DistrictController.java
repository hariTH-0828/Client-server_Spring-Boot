package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.exception.ResourceNotFound;
import edu.mobile.voting.model.District;
import edu.mobile.voting.repository.DistrictRepository;

@RestController
@RequestMapping("/api/district")
public class DistrictController {
	
	@Autowired
	private DistrictRepository districtRepository;

	@GetMapping("/getAll")
	public List<District> getAllDistrict(District district) {
		return districtRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<District> getDistrictById(@PathVariable("id") int id) {
		return new ResponseEntity<District>(districtRepository.findById(id).orElseThrow(() -> new ResourceNotFound("District", "id", id)), HttpStatus.OK);
	}
	
	@GetMapping("state/{id}")
	public List<District> getDistrictByStateId(@PathVariable("id")int id){
		return districtRepository.findByStateId(id);
	}
	
	@GetMapping("search/{districtName}")
	public int getDistrictIdByName(@PathVariable("districtName") String districtName) {
		return districtRepository.findByDistrict(districtName).getId();
	}
	
	@PostMapping("/setDistrict")
	public ResponseEntity<District> saveDistrict(@RequestBody District district){
		return new ResponseEntity<District>(districtRepository.save(district), HttpStatus.CREATED);
	}
	
	
}

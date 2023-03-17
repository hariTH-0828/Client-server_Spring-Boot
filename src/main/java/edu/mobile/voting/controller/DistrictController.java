package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.District;
import edu.mobile.voting.service.DistrictService;

@RestController
@RequestMapping("/api/district")
public class DistrictController {
	
	public DistrictController(DistrictService districtService) {
		super();
		this.districtService = districtService;
	}

	private DistrictService districtService;

	@GetMapping("/getAll")
	public List<District> getAllDistrict(District district) {
		return districtService.getAllDistrict(district);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<District> getDistrictById(@PathVariable("id") int id) {
		return new ResponseEntity<District>(districtService.getDistrictById(id), HttpStatus.OK);
	}
	
	@GetMapping("state/{id}")
	public List<District> getDistrictByStateId(@PathVariable("id")int id){
		return districtService.getDistrictByStataId(id);
	}
	
	@GetMapping("search/{districtName}")
	public int getDistrictIdByName(@PathVariable("districtName") String districtName) {
		return districtService.getDistrictIdByName(districtName);
	}
	
	@PostMapping("/setDistrict")
	public ResponseEntity<District> saveDistrict(@RequestBody District district){
		return new ResponseEntity<District>(districtService.saveDistrict(district), HttpStatus.CREATED);
	}
	
	
}

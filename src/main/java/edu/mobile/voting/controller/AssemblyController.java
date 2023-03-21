package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.exception.ResourceNotFound;
import edu.mobile.voting.model.AssemblyConstituency;
import edu.mobile.voting.repository.AssemblyRepository;

@RestController
@RequestMapping("/api/assembly")
public class AssemblyController {

	@Autowired
	private AssemblyRepository assemblyRepository;
	
	@GetMapping("getAll")
	public ResponseEntity<List<AssemblyConstituency>> getAllAssembly(AssemblyConstituency assemblyConstituency){
		return new ResponseEntity<List<AssemblyConstituency>>(assemblyRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AssemblyConstituency> getById(@PathVariable("id") int id){
		return new ResponseEntity<AssemblyConstituency>(assemblyRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Assembly", "id", id)), HttpStatus.OK);
	}
	
	@GetMapping("district/{district_id}")
	public List<AssemblyConstituency> getByDistrictId(@PathVariable("district_id") int id) {
		return assemblyRepository.findByDistrictId(id);
	}
	
	@PostMapping("setAssembly")
	public ResponseEntity<AssemblyConstituency> setAssembly(@RequestBody AssemblyConstituency assemblyConstituency){
		return new ResponseEntity<AssemblyConstituency>(assemblyRepository.save(assemblyConstituency), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		assemblyRepository.deleteById(id);
		return new ResponseEntity<String>("Assembly constitution deleted successfully....", HttpStatus.OK);
	}
}

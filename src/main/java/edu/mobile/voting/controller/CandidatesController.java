package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.Candidates;
import edu.mobile.voting.model.DataFileInfo;
import edu.mobile.voting.model.Promises;
import edu.mobile.voting.repository.CandidatesRepository;
import edu.mobile.voting.repository.DataFileRepo;

@RestController
@RequestMapping("/api/Candidates")
public class CandidatesController {

	@Autowired
	private CandidatesRepository candidatesRepo;
	
	@Autowired private DataFileRepo fileRepo;

	@GetMapping("/getAll")
	public List<Candidates> getAllCandidates(Candidates candidates) {
		return candidatesRepo.findAll();
	}

	@PostMapping("/save")
	public Candidates saveCandidates(@RequestBody Candidates candidates) {
		return candidatesRepo.save(candidates);
	}

	@GetMapping("/getPromises/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Promises> getPromises(@PathVariable("id") int id) {
		Candidates candidates = candidatesRepo.findById(id).get();
		return candidates.getPromises();
	}
	
	@PutMapping("updateProfile/{id}") 
	public ResponseEntity<Boolean> updatePhoto(@PathVariable("id") int id, @RequestParam long imageId) {
	Candidates candidates = candidatesRepo.findById(id).get();
	DataFileInfo userProfile = fileRepo.findById(imageId).get();
	
	if(userProfile.getId() != 0 && candidates.getId() != 0) {
		candidates.setCandidateImageId(userProfile);
		candidatesRepo.save(candidates);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}else return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	
	}

	// Test method
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String deleteCandidates(@PathVariable("id") int id) {
		candidatesRepo.deleteById(id);
		return "Candidate Delete successfully";
	}
}

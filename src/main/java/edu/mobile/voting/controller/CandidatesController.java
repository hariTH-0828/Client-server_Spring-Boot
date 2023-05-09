package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.Candidates;
import edu.mobile.voting.model.Promises;
import edu.mobile.voting.repository.CandidatesRepository;

@RestController
@RequestMapping("/api/Candidates")
public class CandidatesController {

	@Autowired
	private CandidatesRepository candidatesRepo;

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

	// Test method
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String deleteCandidates(@PathVariable("id") int id) {
		candidatesRepo.deleteById(id);
		return "Candidate Delete successfully";
	}
}

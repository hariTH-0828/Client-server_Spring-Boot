package edu.mobile.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mobile.voting.model.PoliticalParties;
import edu.mobile.voting.repository.PartyNameRepository;

@RestController
@RequestMapping("/api/parties")
public class PoliticalPartyController {

	@Autowired
	private PartyNameRepository partyNameRepo;

	@GetMapping("/getAll")
	public List<PoliticalParties> getAllParties(PoliticalParties parties) {
		return partyNameRepo.findAll();
	}

}

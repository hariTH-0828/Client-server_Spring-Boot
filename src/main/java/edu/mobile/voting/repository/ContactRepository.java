package edu.mobile.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}

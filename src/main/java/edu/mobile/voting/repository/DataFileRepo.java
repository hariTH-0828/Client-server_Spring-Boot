package edu.mobile.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mobile.voting.model.DataFileInfo;

public interface DataFileRepo extends JpaRepository<DataFileInfo, Long>{

}

package tn.itserv.covid19tracker.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.itserv.covid19tracker.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	
	public Optional<Country> findByName(String name);

}

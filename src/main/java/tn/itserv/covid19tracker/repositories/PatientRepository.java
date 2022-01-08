package tn.itserv.covid19tracker.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.itserv.covid19tracker.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	Optional<Patient> findByFullNameAndBirthDate(String fullName, LocalDate birthDate);

}

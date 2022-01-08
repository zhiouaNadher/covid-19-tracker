package tn.itserv.covid19tracker.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.itserv.covid19tracker.dto.VaccinDto;
import tn.itserv.covid19tracker.entities.Vaccin;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccin, Long> {

	@Query("SELECT new tn.itserv.covid19tracker.dto.VaccinDto(ct.patient.id, ct.patient.fullName, ct.patient.address, ct.patient.birthDate, "
			+ "ct.id , ct.vaccinDate) " + "from Vaccin ct ")
	public Page<VaccinDto> findAllVaccin(Pageable pageable);
}

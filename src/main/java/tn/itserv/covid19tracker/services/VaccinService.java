package tn.itserv.covid19tracker.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.itserv.covid19tracker.dto.CovidCaseDto;
import tn.itserv.covid19tracker.dto.VaccinDto;
import tn.itserv.covid19tracker.entities.Vaccin;

public interface VaccinService {

	public VaccinDto save(VaccinDto vaccinDto);

	public Page<VaccinDto> findAllVaccins(Pageable pageable);

	public VaccinDto update(VaccinDto covidCaseDto, Long id);

	public VaccinDto delete(Vaccin covidTest, Long id);

}

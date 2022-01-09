package tn.itserv.covid19tracker.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.itserv.covid19tracker.dto.CovidCaseDto;
import tn.itserv.covid19tracker.entities.CovidTest;

public interface CovidCaseService {
	
	public CovidCaseDto save(CovidCaseDto covidCaseDto);
	public CovidCaseDto update(CovidCaseDto covidCaseDto,Long id);
	public CovidCaseDto delete(CovidTest covidTest,Long id);

	public List<Object[]> findAllDay();
	public List<Object[]> findAllMouth();
	public List<Object[]> findAllYear();

	 
	public Page<CovidCaseDto> findAll(Pageable pageable);

}

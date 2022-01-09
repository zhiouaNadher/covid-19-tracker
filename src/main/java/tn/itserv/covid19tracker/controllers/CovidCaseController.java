package tn.itserv.covid19tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itserv.covid19tracker.dto.CovidCaseDto;
import tn.itserv.covid19tracker.entities.CovidTest;
import tn.itserv.covid19tracker.services.CovidCaseService;

/**
 * Main controller for covid case
 *
 * @author Nadher Zhioua
 * @since 1.0.0
 */
@RestController
@RequestMapping(Navigation.API_COVID_CASES)
public class CovidCaseController {

	@Autowired
	private CovidCaseService covidCaseService;

	@PostMapping("/create")
	public CovidCaseDto create(@RequestBody CovidCaseDto covidCaseDto) {
		return covidCaseService.save(covidCaseDto);
	}

	@PostMapping("/update/{id}")
	public CovidCaseDto update(@RequestBody CovidCaseDto covidCaseDto, @PathVariable() Long id) {
		return covidCaseService.update(covidCaseDto, id);
	}

	@PostMapping("/delete/{id}")
	public void delete(@RequestBody CovidTest covidTest, @PathVariable() Long id) {
		covidCaseService.delete(covidTest, id);
	}

	@GetMapping("/list")
	public Page<CovidCaseDto> findAll(Pageable pageable) {
		return covidCaseService.findAll(pageable);
	}

	@GetMapping("/day")
	public List<Object[]> findAllDay() {
		return covidCaseService.findAllDay();
	}

	@GetMapping("/mouth")
	public List<Object[]> findAllMouth() {
		return covidCaseService.findAllMouth();
	}

	@GetMapping("/year")
	public List<Object[]> findAllYear() {
		return covidCaseService.findAllYear();
	}

}

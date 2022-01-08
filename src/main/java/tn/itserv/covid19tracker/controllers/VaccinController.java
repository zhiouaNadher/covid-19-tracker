package tn.itserv.covid19tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itserv.covid19tracker.dto.VaccinDto;
import tn.itserv.covid19tracker.entities.Vaccin;
import tn.itserv.covid19tracker.services.VaccinService;

/**
 * Main controller for vaccin
 *
 * @author Nadher Zhioua
 * @since 1.0.0
 */
@RestController
@RequestMapping(Navigation.API_COVID_VACCINATION)
public class VaccinController {

	@Autowired
	public VaccinService vaccinService;

	@GetMapping
	public Page<VaccinDto> findAll(Pageable pageable) {
		return this.vaccinService.findAllVaccins(pageable);
	}

	@PostMapping("/create")
	public VaccinDto create(@RequestBody VaccinDto vaccinDto) {
		return vaccinService.save(vaccinDto);
	}

	@PostMapping("/update/{id}")
	public VaccinDto update(@RequestBody VaccinDto vaccinDto, @PathVariable() Long id) {
		return vaccinService.update(vaccinDto, id);
	}

	@PostMapping("/delete/{id}")
	public void delete(@RequestBody Vaccin vaccin, @PathVariable() Long id) {
		vaccinService.delete(vaccin, id);
	}

}

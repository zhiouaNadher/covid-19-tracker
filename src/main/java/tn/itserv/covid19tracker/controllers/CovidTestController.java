package tn.itserv.covid19tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.itserv.covid19tracker.dto.CovidTestDto;
import tn.itserv.covid19tracker.entities.CovidTest;
import tn.itserv.covid19tracker.services.CovidTestService;

@RestController
@RequestMapping(name = Navigation.API_COVID_TEST)
public class CovidTestController {

	@Autowired
	CovidTestService covidTestService;

	@GetMapping
	public Page<CovidTest> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
		return covidTestService.findAll(PageRequest.of(page, size));
	}

	
}

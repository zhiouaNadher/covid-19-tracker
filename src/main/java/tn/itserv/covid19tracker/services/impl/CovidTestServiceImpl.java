package tn.itserv.covid19tracker.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.itserv.covid19tracker.entities.CovidTest;
import tn.itserv.covid19tracker.repositories.CovidTestRepository;
import tn.itserv.covid19tracker.services.CovidTestService;

/**
 * Service handling covid test
 *
 * @author Nadher Zhioua
 * @since 1.0.0
 */
@Slf4j
@Service
public class CovidTestServiceImpl implements CovidTestService {

	@Autowired
	@Qualifier("covidTestRepository")
	CovidTestRepository covidTestRepository;

	public CovidTest save(CovidTest covidTest) {
		return covidTestRepository.save(covidTest);
	}

	public Page<CovidTest> findAll(Pageable pageable) {
		return covidTestRepository.findAll(pageable);
	}

	public Optional<CovidTest> findById(Long id) {
		return covidTestRepository.findById(id);
	}

	public void delete(Long id) {
		covidTestRepository.deleteById(id);
	}

	public void delete(CovidTest covidTest) {
		covidTestRepository.delete(covidTest);
	}

	public void update(CovidTest p, Long id) {
		try {
			CovidTest covidTest = this.covidTestRepository.findById(id).get();
			covidTest.setCovidTestDate(LocalDateTime.now());
			covidTest.setCovidTestResult(p.getCovidTestResult());
			this.covidTestRepository.save(covidTest);
			System.err.println("----------- " + p.getCovidTestResult()); 
		} catch (Exception ex) {
			System.err.println("----------- " + ex.getMessage()); 
		}
	}
}

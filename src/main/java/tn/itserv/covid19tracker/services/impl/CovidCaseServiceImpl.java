package tn.itserv.covid19tracker.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.itserv.covid19tracker.dto.CovidCaseDto;
import tn.itserv.covid19tracker.entities.Country;
import tn.itserv.covid19tracker.entities.CovidTest;
import tn.itserv.covid19tracker.entities.Patient;
import tn.itserv.covid19tracker.repositories.CountryRepository;
import tn.itserv.covid19tracker.repositories.CovidTestRepository;
import tn.itserv.covid19tracker.repositories.PatientRepository;
import tn.itserv.covid19tracker.services.CovidCaseService;

@Service
@Transactional
public class CovidCaseServiceImpl implements CovidCaseService {

	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private CovidTestRepository covidTestRepository;

	@Override
	public CovidCaseDto save(CovidCaseDto covidCaseDto) {

		Optional<Country> country = countryRepository.findByName(covidCaseDto.getPatientCountry());

		if (!country.isPresent()) {
			Country countrytemp = new Country();
			countrytemp.setName(covidCaseDto.getPatientCountry());
			country = Optional.of(countryRepository.save(countrytemp));
		}

		Optional<Patient> patient = patientRepository.findByFullNameAndBirthDate(covidCaseDto.getPatientFullName(),
				covidCaseDto.getPatientBirthdate());

		if (!patient.isPresent()) {
			Patient patientTemp = new Patient();
			patientTemp.setFullName(covidCaseDto.getPatientFullName());
			patientTemp.setBirthDate(covidCaseDto.getPatientBirthdate());
			patientTemp.setAddress(covidCaseDto.getPatientAdress());
			patientTemp.setCountry(country.get());
			patient = Optional.of(patientRepository.save(patientTemp));
		}

		CovidTest covidTest = new CovidTest();
		covidTest.setCovidTestDate(LocalDateTime.now());
		covidTest.setCovidTestResult(covidCaseDto.getCovidTestResult());
		covidTest.setPatient(patient.get());

		covidTest = covidTestRepository.save(covidTest);

		covidCaseDto.setPatientId(patient.get().getId());
		covidCaseDto.setCovidTestId(covidTest.getId());
		return covidCaseDto;
	}

	@Override
	public CovidCaseDto update(CovidCaseDto covidCaseDto, Long id) {
		try {
			System.out.println(covidCaseDto.getCovidTestResult() + "CovidCaseServiceImpl ----- update " + id);
			Optional<Country> country = countryRepository.findByName(covidCaseDto.getPatientCountry());

			if (!country.isPresent()) {
				Country countrytemp = new Country();
				countrytemp.setName(covidCaseDto.getPatientCountry());
				country = Optional.of(countryRepository.save(countrytemp));
			}

			Optional<CovidTest> covidTest = covidTestRepository.findById(id);
			System.out.println(covidTest.get().getId() + "************ " + covidTest.get().getPatient().getId());
			Optional<Patient> patient = patientRepository.findById(covidTest.get().getPatient().getId());

			if (!patient.isPresent()) {
				Patient patientTemp = new Patient();
				patientTemp.setFullName(covidCaseDto.getPatientFullName());
				patientTemp.setBirthDate(covidCaseDto.getPatientBirthdate());
				patientTemp.setAddress(covidCaseDto.getPatientAdress());
				patientTemp.setCountry(country.get());
				patient = Optional.of(patientRepository.save(patientTemp));
			}

			CovidTest covidTestTemp = new CovidTest();
			covidTestTemp.setId(id);
			covidTestTemp.setCovidTestDate(LocalDateTime.now());
			covidTestTemp.setCovidTestResult(covidCaseDto.getCovidTestResult());
			covidTestTemp.setPatient(patient.get());
			covidTestRepository.save(covidTestTemp); 
		} catch (Exception ex) {

		}
		return covidCaseDto;
	}

	@Override
	public Page<CovidCaseDto> findAll(Pageable pageable) {
		return covidTestRepository.findAllCovidCases(pageable);
	}

	@Override
	public CovidCaseDto delete(CovidTest covidTest, Long id) {
		System.out.println("**CovidCaseServiceImpl**** " + id);
		// TODO Auto-generated method stub
		try {
			CovidTest covidTestTemp = this.covidTestRepository.findById(id).get();
			this.covidTestRepository.delete(covidTestTemp);

		} catch (Exception ex) {
		}
		return null;
	}
 

}

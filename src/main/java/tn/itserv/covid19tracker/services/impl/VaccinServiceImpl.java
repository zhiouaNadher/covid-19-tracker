package tn.itserv.covid19tracker.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.itserv.covid19tracker.dto.CovidCaseDto;
import tn.itserv.covid19tracker.dto.VaccinDto;
import tn.itserv.covid19tracker.entities.Country;
import tn.itserv.covid19tracker.entities.CovidTest;
import tn.itserv.covid19tracker.entities.Patient;
import tn.itserv.covid19tracker.entities.Vaccin;
import tn.itserv.covid19tracker.repositories.PatientRepository;
import tn.itserv.covid19tracker.repositories.VaccinRepository;
import tn.itserv.covid19tracker.services.VaccinService;

@Service
@Transactional
public class VaccinServiceImpl implements VaccinService {

	@Autowired
	VaccinRepository vaccinRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Page<VaccinDto> findAllVaccins(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.vaccinRepository.findAllVaccin(pageable);
	}

	@Override
	public VaccinDto save(VaccinDto vaccinDto) {
		// TODO Auto-generated method stub
		Optional<Patient> patient = patientRepository.findByFullNameAndBirthDate(vaccinDto.getPatientFullName(),
				vaccinDto.getPatientBirthdate());

		if (!patient.isPresent()) {
			Patient patientTemp = new Patient();
			patientTemp.setFullName(vaccinDto.getPatientFullName());
			patientTemp.setBirthDate(vaccinDto.getPatientBirthdate());
			patientTemp.setAddress(vaccinDto.getPatientAdress());
			patient = Optional.of(patientRepository.save(patientTemp));
		}

		Vaccin vaccin = new Vaccin();
		vaccin.setVaccinDate(LocalDateTime.now());
		vaccin.setPatient(patient.get());

		vaccin = vaccinRepository.save(vaccin);

		vaccinDto.setPatientId(patient.get().getId());
		vaccinDto.setVaccintId(vaccinDto.getVaccintId());
		return null;
	}

	@Override
	public VaccinDto update(VaccinDto vaccinDto, Long id) {
		try { 
			 
			Optional<Vaccin> vaccin = vaccinRepository.findById(id);
			System.out.println(vaccin.get().getId() + "************ " + vaccin.get().getPatient().getId());
			Optional<Patient> patient = patientRepository.findById(vaccin.get().getPatient().getId());

			if (!patient.isPresent()) {
				Patient patientTemp = new Patient();
				patientTemp.setFullName(vaccinDto.getPatientFullName());
				patientTemp.setBirthDate(vaccinDto.getPatientBirthdate());
				patientTemp.setAddress(vaccinDto.getPatientAdress()); 
				patient = Optional.of(patientRepository.save(patientTemp));
			}

			Vaccin vaccinTemp = new Vaccin();
			vaccinTemp.setId(id);
			vaccinTemp.setVaccinDate(LocalDateTime.now()); 
			vaccinTemp.setPatient(patient.get());
			vaccinRepository.save(vaccinTemp); 
		} catch (Exception ex) {

		}
		return vaccinDto;
	}

	@Override
	public VaccinDto delete(Vaccin vaccin, Long id) {
		System.out.println("**CovidCaseServiceImpl**** " + id);
		// TODO Auto-generated method stub
		try {
			Vaccin vaccinTemp = this.vaccinRepository.findById(id).get();
			this.vaccinRepository.delete(vaccinTemp);

		} catch (Exception ex) {
		}
		return null;
	}

}

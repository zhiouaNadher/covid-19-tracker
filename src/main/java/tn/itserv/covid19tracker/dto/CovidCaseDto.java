package tn.itserv.covid19tracker.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import tn.itserv.covid19tracker.entities.CovidTestResult;

@Data
public class CovidCaseDto {
	
	private Long patientId;
	private String patientFullName;
	private String patientAdress;
	private String patientCountry;
	private LocalDate patientBirthdate;
	private Long covidTestId;
	private CovidTestResult covidTestResult;
	private LocalDateTime covidTestDate;
	
	public CovidCaseDto(Long patientId, String patientFullName, String patientAdress, String patientCountry,
			LocalDate patientBirthdate, Long covidTestId, CovidTestResult covidTestResult, LocalDateTime covidTestDate) {
		super();
		this.patientId = patientId;
		this.patientFullName = patientFullName;
		this.patientAdress = patientAdress;
		this.patientCountry = patientCountry;
		this.patientBirthdate = patientBirthdate;
		this.covidTestId = covidTestId;
		this.covidTestResult = covidTestResult;
		this.covidTestDate = covidTestDate;
	}
	
	
	
	

}

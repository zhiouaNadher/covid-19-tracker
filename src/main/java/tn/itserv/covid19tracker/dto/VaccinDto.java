package tn.itserv.covid19tracker.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VaccinDto {

	private Long patientId;
	private String patientFullName;
	private String patientAdress;
	private LocalDate patientBirthdate;
	private Long vaccintId;
	private LocalDateTime vaccinDate;

	public VaccinDto(Long patientId, String patientFullName, String patientAdress, LocalDate patientBirthdate,
			Long vaccintId, LocalDateTime vaccinDate) {
		super();
		this.patientId = patientId;
		this.patientFullName = patientFullName;
		this.patientAdress = patientAdress;
		this.patientBirthdate = patientBirthdate;
		this.vaccintId = vaccintId;
		this.vaccinDate = vaccinDate;
	}

}

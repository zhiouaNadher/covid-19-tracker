package tn.itserv.covid19tracker.dto;

 

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Data;
import tn.itserv.covid19tracker.entities.CovidTestResult; 

@Data
public class CovidTestDto {

	
	private CovidTestResult covidTestResult;  
	private LocalDateTime covidTestDate ;
	private Long patientId;
}

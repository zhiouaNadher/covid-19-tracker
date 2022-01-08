package tn.itserv.covid19tracker.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * The persistent class for the covid_test database table.
 *
 * @author Nadher Zhioua
 * @since 1.0.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CovidTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CovidTestResult covidTestResult; 

	@Column(nullable = false)
	private LocalDateTime covidTestDate ;

	@ManyToOne
	@JoinColumn(nullable = false, name = "patient_id")
	private Patient patient;

}

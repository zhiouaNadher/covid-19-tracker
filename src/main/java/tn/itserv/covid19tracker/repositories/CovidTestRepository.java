package tn.itserv.covid19tracker.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.itserv.covid19tracker.dto.CovidCaseDto;
import tn.itserv.covid19tracker.entities.CovidTest;
import tn.itserv.covid19tracker.entities.Patient;

/**
 * Repository for covid_test Table.
 *
 * @author Nadher Zhioua
 * @since 1.0.0
 */
@Repository
public interface CovidTestRepository extends JpaRepository<CovidTest, Long> {

	@Query("SELECT new tn.itserv.covid19tracker.dto.CovidCaseDto(ct.patient.id, ct.patient.fullName, ct.patient.address, ct.patient.country.name,"
			+ " ct.patient.birthDate, ct.id, ct.covidTestResult, ct.covidTestDate) " + "from CovidTest ct ")
	public Page<CovidCaseDto> findAllCovidCases(Pageable pageable);

	@Query(value = "SELECT p.country_name  ,TO_CHAR(ct.COVID_TEST_DATE ,'DD/MM/YYYY') , count(*) "
			+ "from patient p " + "join Covid_Test ct  on p.id = ct.patient_id "
			+ "  group by p.country_name  ,TO_CHAR(ct.COVID_TEST_DATE ,'DD/MM/YYYY') "
			+ "            order by count(*)  desc LIMIT 3", nativeQuery = true)
	public List<Object[]> findAllCovidCasesDay();

	@Query(value = "SELECT p.country_name  ,TO_CHAR(ct.COVID_TEST_DATE ,'MM/YYYY') , count(*) "
			+ "from patient p " + "join Covid_Test ct  on p.id = ct.patient_id "
			+ "  group by p.country_name  ,TO_CHAR(ct.COVID_TEST_DATE ,'MM/YYYY') "
			+ "            order by count(*)  desc LIMIT 3", nativeQuery = true)
	public List<Object[]> findAllCovidCasesMouth();

	@Query(value = "SELECT p.country_name  ,TO_CHAR(ct.COVID_TEST_DATE ,'YYYY') , count(*) " + "from patient p "
			+ "join Covid_Test ct  on p.id = ct.patient_id "
			+ "  group by p.country_name  ,TO_CHAR(ct.COVID_TEST_DATE ,'YYYY') "
			+ "            order by count(*)  desc LIMIT 3", nativeQuery = true)
	public List<Object[]> findAllCovidCasesYear();

}

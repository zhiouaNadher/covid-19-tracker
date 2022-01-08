package tn.itserv.covid19tracker.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.itserv.covid19tracker.entities.CovidTest;

/**
 * Service handling covid test
 *
 * @author Nadher Zhioua
 * @since 1.0.0
 */
public interface CovidTestService {

    public CovidTest save(CovidTest covidTest);
    public Page<CovidTest> findAll(Pageable pageable);
    public void update(CovidTest covidTest , Long id);
    public Optional<CovidTest> findById(Long id);
    public void delete(Long id);
    public void delete(CovidTest covidTest);
}

package tn.itserv.covid19tracker.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import tn.itserv.covid19tracker.entities.CovidTest;
import tn.itserv.covid19tracker.services.impl.CovidTestServiceImpl;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan("tn.itserv.covid19tracker")
public class CovidTestServiceTest {

    @Autowired
    CovidTestServiceImpl covidTestService;

    @Test
    public void testCreateReadDelete() {
        CovidTest covidTest = new CovidTest();
        covidTest = covidTestService.save(covidTest);
        Assertions.assertTrue(covidTestService.findById(covidTest.getId()).isPresent());
        covidTestService.delete(covidTest.getId());
        Assertions.assertFalse(covidTestService.findById(covidTest.getId()).isPresent());
    }

}

package tn.itserv.covid19tracker.controllers;

/**
 * This class centralizes navigation urls.
 *
 * @author Nadher Zhioua
 * @since 1.0.0
 */
public class Navigation {


    private Navigation() {
        // private constructor to prevent construction
    }

    public static final String API_COVID_CASES = "/api/covid-cases";
    public static final String API_COVID_TEST = "/api/covid-test";
    public static final String API_COVID_VACCINATION = "/api/covid-vaccination";
}
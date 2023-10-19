package ge.davidgogishvili.projects.marketshop.services;

import ge.davidgogishvili.projects.marketshop.entities.Company;
import ge.davidgogishvili.projects.marketshop.entities.Country;

import java.util.List;

public interface CountryService {


    List<Country> search(Integer id, String countryName, String isoCode2, String isoCode3);


    Country getCountry(Integer id);
}

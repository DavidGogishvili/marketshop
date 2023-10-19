package ge.davidgogishvili.projects.marketshop.controllers;

import ge.davidgogishvili.projects.marketshop.entities.Country;
import ge.davidgogishvili.projects.marketshop.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CountryController {


    private final CountryService countryService;

    @GetMapping("countries")
    public List<Country> search (Integer id, String countryName, String isoCode2, String isoCode3) {
        return countryService.search(id, countryName, isoCode2, isoCode3);


    }

    @GetMapping ("countries/{id}")
    public Country country(@PathVariable Integer id) {
        return countryService.getCountry(id);
    }

}

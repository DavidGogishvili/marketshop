package ge.davidgogishvili.projects.marketshop.services.implementations;
import ge.davidgogishvili.projects.marketshop.entities.Country;
import ge.davidgogishvili.projects.marketshop.repositories.CountryRepo;
import ge.davidgogishvili.projects.marketshop.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CountryServiceImpl implements CountryService {


    private final CountryRepo countryRepository;
    @Override
    public List<Country> search( Integer id, String countryName, String isoCode2, String isoCode3) {
        return countryRepository.findAll();
    }

    public Country getCountry (Integer id) {
        return countryRepository.findById(id).orElseThrow();
    }
}

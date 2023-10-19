package ge.davidgogishvili.projects.marketshop.repositories;

import ge.davidgogishvili.projects.marketshop.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository <Country, Integer> {



}

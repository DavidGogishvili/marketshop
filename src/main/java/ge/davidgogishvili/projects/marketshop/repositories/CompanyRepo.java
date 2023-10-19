package ge.davidgogishvili.projects.marketshop.repositories;

import ge.davidgogishvili.projects.marketshop.entities.Company;
import ge.davidgogishvili.projects.marketshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepo extends JpaRepository <Company, Integer> {


    List<Company> findAllByOriginalName(String originalName);
}

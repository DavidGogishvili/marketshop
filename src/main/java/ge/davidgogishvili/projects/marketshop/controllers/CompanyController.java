package ge.davidgogishvili.projects.marketshop.controllers;

import ge.davidgogishvili.projects.marketshop.entities.Company;
import ge.davidgogishvili.projects.marketshop.models.CompanyCreateModel;
import ge.davidgogishvili.projects.marketshop.repositories.CompanyRepo;
import ge.davidgogishvili.projects.marketshop.services.CompanyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class CompanyController {


    private final CompanyService companyService;


    @GetMapping("companiesByName")
    public List <Company> find (String originalName, String nameGeo) {
        return companyService.find(originalName, nameGeo);
    }

    @GetMapping("companies")
    public List <Company> search (String parentId, String countryId, String originalName,
                                  String nameGeo, String active, String changedBy, String changedAt, String createdBy, String createdAt) {
        return companyService.search( parentId, countryId, originalName, nameGeo, active, changedBy, changedAt, createdBy, createdAt);
    }

    @GetMapping("companies/{id}")
    public Company company(@PathVariable Integer id) {
    return companyService.getCompany(id);
    }


    @PostMapping("{companyId}/create")
    public Company createCompany(@PathVariable Integer companyId, @RequestBody CompanyCreateModel companyCreateModel) {
        return companyService.createCompany(companyId, companyCreateModel);
    }

}

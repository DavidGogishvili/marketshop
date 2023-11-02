package ge.davidgogishvili.projects.marketshop.controllers;

import ge.davidgogishvili.projects.marketshop.entities.Company;
import ge.davidgogishvili.projects.marketshop.models.CompanyCreateModel;
import ge.davidgogishvili.projects.marketshop.repositories.CompanyRepo;
import ge.davidgogishvili.projects.marketshop.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController


public class CompanyController {


    private final CompanyService companyService;


    @GetMapping("companiesByName")
    @Operation (tags = "Companies", summary = "კომპანიების ძებნა სახელის მიხედვით")
    public List <Company> find (String originalName, String nameGeo) {
        return companyService.find(originalName, nameGeo);
    }

    @GetMapping("Companies")
    @Operation (tags = "Companies", summary = "კომპანიების ძებნა")

    public List <Company> search (String parentId, String countryId, String originalName,
                                  String nameGeo, String active, String changedBy, String changedAt, String createdBy, String createdAt) {
        return companyService.search( parentId, countryId, originalName, nameGeo, active, changedBy, changedAt, createdBy, createdAt);
    }

    @GetMapping("companies/{id}")
    @Operation (tags = "Companies", summary = "კომპანიების ძებნა აიდის მიხედვით")

    public Company company(@PathVariable Integer id) {
    return companyService.getCompany(id);
    }


    @PostMapping("createCompany/{companyId}/create")
    @Operation (tags = "Companies", summary = "ახალი კომპანიის დამატება")

    public Company createCompany(@PathVariable Integer companyId, @RequestBody CompanyCreateModel companyCreateModel) {
        return companyService.createCompany(companyId, companyCreateModel);
    }

}

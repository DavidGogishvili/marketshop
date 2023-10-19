package ge.davidgogishvili.projects.marketshop.services.implementations;
import ge.davidgogishvili.projects.marketshop.entities.Company;
import ge.davidgogishvili.projects.marketshop.models.CompanyCreateModel;
import ge.davidgogishvili.projects.marketshop.repositories.CompanyRepo;
import ge.davidgogishvili.projects.marketshop.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepo companyRepo;



    @Override
    public List<Company> search(String parentId, String countryId, String originalName, String nameGeo, String active,
                                String changedBy, String changedAt, String createdBy, String createdAt) {

        return companyRepo.findAll();
    }




    @Override
    public Company getCompany(Integer id) {
        return companyRepo.findById(id).orElseThrow();
    }

    @Override
    public Company createCompany(Integer companyId, CompanyCreateModel companyCreateModel) {

        Company company = new Company();
        company.setCompanyId(companyId);
        company.setName(companyCreateModel.originalName());
        company.setParentId(companyCreateModel.parentId());
        company.setCountryId(companyCreateModel.countryId());
        companyRepo.save(company);
        return company;
    }

    @Override
    public List<Company> findAllByOriginalName(String originalName, String nameGeo) {
        return companyRepo.findAll();
    }

    @Override
    public List<Company> find(String originalName, String nameGeo) {
       return companyRepo.findAllByOriginalName(originalName);
    }

}

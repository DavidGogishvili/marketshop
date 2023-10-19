package ge.davidgogishvili.projects.marketshop.services;

import ge.davidgogishvili.projects.marketshop.entities.Company;
import ge.davidgogishvili.projects.marketshop.models.CompanyCreateModel;

import java.util.List;


public interface CompanyService {

    List<Company> search(String parentId, String countryId, String originalName, String nameGeo, String active,
                         String changedBy, String changedAt, String createdBy, String createdAt);



    Company getCompany(Integer id);

    Company createCompany(Integer companyId, CompanyCreateModel companyCreateModel);



    List<Company> findAllByOriginalName(String originalName, String nameGeo);

    List<Company> find (String originalName, String nameGeo);

}



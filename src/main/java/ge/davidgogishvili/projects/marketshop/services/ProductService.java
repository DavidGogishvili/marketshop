package ge.davidgogishvili.projects.marketshop.services;

import ge.davidgogishvili.projects.marketshop.entities.Product;
import ge.davidgogishvili.projects.marketshop.models.ProductCreateModel;

import java.util.List;

public interface ProductService {
    List <Product> search(String eanCode, String productName, String companyId, String countryId, String productDesc,
                         String isActive, String changedBy, String changedAt, String createdBy, String createdAt);

    Product createProduct(Integer id, ProductCreateModel productCreateModel);


}

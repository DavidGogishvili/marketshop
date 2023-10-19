package ge.davidgogishvili.projects.marketshop.services.implementations;

import ge.davidgogishvili.projects.marketshop.entities.Product;
import ge.davidgogishvili.projects.marketshop.models.CompanyCreateModel;
import ge.davidgogishvili.projects.marketshop.models.ProductCreateModel;
import ge.davidgogishvili.projects.marketshop.repositories.CompanyRepo;
import ge.davidgogishvili.projects.marketshop.repositories.ProductRepo;
import ge.davidgogishvili.projects.marketshop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepo productRepo;

    @Override
    public List <Product> search (String eanCode, String productName, String companyId, String countryId, String productDesc, String isActive,
                                  String changedBy, String changedAt, String createdBy, String createdAt) {
        return productRepo.findAllByEanCode(eanCode);
    }

    @Override
    public Product createProduct (Integer productId, ProductCreateModel productCreateModel) {
        Product product = new Product();
        product.setId(productId);
        product.setEanCode(productCreateModel.EanCode());
        product.setProductName(productCreateModel.name());
        product.setCompanyId(productCreateModel.companyId());
        product.setCountryId(productCreateModel.countryId());
        return product;
    }

}

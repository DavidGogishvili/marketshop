package ge.davidgogishvili.projects.marketshop.controllers;


import ge.davidgogishvili.projects.marketshop.entities.Product;
import ge.davidgogishvili.projects.marketshop.models.ProductCreateModel;
import ge.davidgogishvili.projects.marketshop.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    @Operation(tags = "Products", summary = "პროდუქტების ძიება")

    public List <Product> search (String eanCode, String productName, String companyId, String countryId, String productDesc, String isActive,
                                  String changedBy, String changedAt, String createdBy, String createdAt) {

        return productService.search(eanCode, productName, companyId, countryId, productDesc, isActive, changedBy, changedAt, createdBy, createdAt);
    }


    @PostMapping("{productId}/create")
    @Operation(tags = "Products", summary = "პროდუქტის შექმნა")

    public Product CreateProduct(@PathVariable Integer productId, @RequestBody ProductCreateModel productCreateModel) {
        return productService.createProduct(productId, productCreateModel);
    }

}

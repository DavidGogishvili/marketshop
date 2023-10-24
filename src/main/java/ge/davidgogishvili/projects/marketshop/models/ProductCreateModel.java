package ge.davidgogishvili.projects.marketshop.models;

import ge.davidgogishvili.projects.marketshop.entities.Product;

public record ProductCreateModel <String> (
        java.lang.String EanCode,
        java.lang.String name,

        Integer companyId,

        Integer countryId
) {
}

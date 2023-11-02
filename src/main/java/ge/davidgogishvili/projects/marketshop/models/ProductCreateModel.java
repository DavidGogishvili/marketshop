package ge.davidgogishvili.projects.marketshop.models;

import ge.davidgogishvili.projects.marketshop.entities.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record ProductCreateModel <String> (

        @NotNull
                @Schema(description = "პროდუქტის ეან კოდი")
        java.lang.String EanCode,

        @NotNull
        @Schema(description = "დასახელება")
        java.lang.String name,

        @NotNull
        @Schema(description = "მწარმოებელი კომპანია")
        Integer companyId,

        @NotNull
        @Schema(description = "მწარმოებელი ქვეყანა")
        Integer countryId
) {
}

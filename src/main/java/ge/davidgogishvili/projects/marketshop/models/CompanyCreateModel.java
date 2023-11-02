package ge.davidgogishvili.projects.marketshop.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CompanyCreateModel (
        @NotNull
                @Schema(description = "კომპანიის სახელი ორიგინალში")
        String originalName,

        @NotNull
                @Schema(description = "იდენტიფიკატორი")
        Integer parentId,

        @NotNull
                @Schema(description = "მწარმოებელი ქვეყანა")
        Integer countryId) {

}

package ge.davidgogishvili.projects.marketshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@OpenAPIDefinition (
		tags = {
				@Tag(name ="Products", description = "პროდუქტები"),
				@Tag(name ="Companies", description = "კომპანიები"),
				@Tag(name ="Countries", description = "ქვეყნები"),
				@Tag(name ="File Management", description = "ფაილების მართვა"),
				@Tag(name ="Coordinates", description = "ატვირთული ფაილიდან მონაცემების ამოღება და ბაზაში ჩაწერა")
		},
		info = @Info (
				title = "მაღაზიის პროგრამა",
				version = "001",
				description = "ონლაინ-მაღაზიის სატესტო პროგრამა",
				contact = @Contact (name = "David Gogishvili"),
				license = @License(
						name = "GNU GPL v3",
						url = "https://www.gnu.org/licenses/gpl-3.0.en.html"
				)
		 )
)

@SpringBootApplication
public class MarketshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketshopApplication.class, args);
	}



}

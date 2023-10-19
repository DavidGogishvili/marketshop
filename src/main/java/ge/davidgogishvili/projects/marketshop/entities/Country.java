package ge.davidgogishvili.projects.marketshop.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table (schema = "public", name = "countries" )
public class Country {

    @Id
    private Integer id;

    @Column (name = "name")
    private String countryName;

    @Column (name = "iso_code_2")
    private String isoCode2;


    @Column(name = "iso_code_3")
    private String isoCode3;

}

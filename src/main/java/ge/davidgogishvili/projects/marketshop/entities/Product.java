package ge.davidgogishvili.projects.marketshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (schema = "public", name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="products_seq-generator")
    @SequenceGenerator(name="products_seq-generator", sequenceName="products_id_sequence", allocationSize = 1)
    private Integer id;

    @Column (name = "ean")
    private String eanCode;

    @Column (name = "name")
    private String productName;

    @Column (name = "company_id")
    private String companyId;

    @Column (name = "country_id")
    private String countryId;

    @Column (name = "description")
    private String productDesc;

    @Column (name = "active")
    private String isActive;

    @Column (name = "changed_by")
    private String changedBy;

    @Column (name = "changed_at")
    private String changedAt;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "created_at")
    private String createdAt;


}

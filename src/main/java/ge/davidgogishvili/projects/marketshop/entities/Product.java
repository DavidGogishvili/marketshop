package ge.davidgogishvili.projects.marketshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table (schema = "public", name = "products")
@SequenceGenerator(name="products_id_sequence-generator", sequenceName="products_id_sequence", allocationSize = 1)

public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="products_id_sequence-generator")
    private Integer id;

    @Column (name = "ean")
    private String eanCode;

    @Column (name = "name")
    private String productName;

    @Column (name = "company_id")
    private Integer companyId;

    @Column (name = "country_id")
    private Integer countryId;

    @Column (name = "description")
    private String productDesc;

    @Column (name = "active")
    private Boolean isActive;

    @Column (name =  "changed_by")
    private Integer changedBy;

    @Column (name =  "changed_at")
    private LocalDateTime changedAt;


    @Column (name = "created_by")
    private Integer createdBy;

    @Column (name =  "created_at")
    private LocalDateTime createdAt;



}

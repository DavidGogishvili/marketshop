package ge.davidgogishvili.projects.marketshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table (schema = "public", name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="companies_seq-generator")
    @SequenceGenerator(name="companies_seq-generator", sequenceName="companies_id_seq", allocationSize = 1)
    private Integer id;

//    @JsonProperty("იდენტიფიკატორი")
    @Column (name = "parent_id")
    private Integer parentId;

    @Column (name = "country_id")
    private Integer countryId;

    @Column (name = "name")
    private String originalName;

    @Column (name = "name_geo")
    private String nameGeo;

    @Column (name = "active")
    private Boolean active;

    @Column (name = "changed_by")
    private Integer changedBy;

    @Column (name = "changed_at")
    private LocalDateTime changedAt;

    @Column (name = "created_by")
    private Integer createdBy;

    @Column (name = "created_at")
    private LocalDateTime createdAt;


}

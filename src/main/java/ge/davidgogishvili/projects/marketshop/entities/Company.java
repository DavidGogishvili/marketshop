package ge.davidgogishvili.projects.marketshop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (schema = "public", name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="companies_seq-generator")
    @SequenceGenerator(name="companies_seq-generator", sequenceName="companies_id_seq", allocationSize = 1)
    private Integer id;

    @JsonProperty("იდენტიფიკატორი")
    @Column (name = "parent_id")
    private String parentId;

    @Column (name = "country_id")
    private String countryId;

    @Column (name = "name")
    private String originalName;

    @Column (name = "name_geo")
    private String nameGeo;

    @Column (name = "active")
    private String active;

    @Column (name = "changed_by")
    private String changedBy;

    @Column (name = "changed_at")
    private String changedAt;

    @Column (name = "created_by")
    private String createdBy;

    @Column (name = "created_at")
    private String createdAt;


    public void setCompanyId(Integer companyId) {
    }


    public void setName(String originalName) {
    }

    public void setParentId(String parentId) {

    }

    public void setCountryId(String countryId) {

    }




}

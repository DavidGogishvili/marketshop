package ge.davidgogishvili.projects.marketshop.Coordinates;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Coordinate {

    @Id
    private Integer id;


    @Column (name = "longtitude")
    private double longtitude;

    @Column (name = "latitude")
    private double latitude;

    @Column (name = "number")
    private String number;

    @Column (name = "last_contact_date")
    private LocalDateTime last_contact_date;
}
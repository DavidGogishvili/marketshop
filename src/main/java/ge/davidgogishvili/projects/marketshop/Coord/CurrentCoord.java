package ge.davidgogishvili.projects.marketshop.Coord;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
public class CurrentCoord {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "number")
    private String number;

    @Column (name = "longtitude")
    private double longtitude;

    @Column (name = "latitude")
    private double latitude;

    @Column (name = "last_contact_date")
    private Timestamp last_contact_date;

    public CurrentCoord(String number, double latitude, double longtitude, Timestamp last_contact_date) {

        this.number = number;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.last_contact_date = last_contact_date;
    }

    public CurrentCoord() {

    }


}

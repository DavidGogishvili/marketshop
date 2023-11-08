package ge.davidgogishvili.projects.marketshop.Coord;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CoordRequest {

    private Integer id;
    private String number;
    private double longtitude;
    private double latitude;
    private Timestamp last_contact_date;




}

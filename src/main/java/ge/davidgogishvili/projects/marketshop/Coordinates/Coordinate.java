package ge.davidgogishvili.projects.marketshop.Coordinates;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Coordinate {

    @Id
    private Integer id;

    private double longtitude;

    private double latitude;
}

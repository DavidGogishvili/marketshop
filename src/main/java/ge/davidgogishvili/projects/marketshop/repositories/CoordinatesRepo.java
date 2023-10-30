package ge.davidgogishvili.projects.marketshop.repositories;

import ge.davidgogishvili.projects.marketshop.entities.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatesRepo extends JpaRepository <Coordinate, Integer> {
}

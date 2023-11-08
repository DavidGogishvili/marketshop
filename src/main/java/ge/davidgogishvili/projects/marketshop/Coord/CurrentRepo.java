package ge.davidgogishvili.projects.marketshop.Coord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentRepo extends JpaRepository <CurrentCoord, Integer> {
}

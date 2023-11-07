package ge.davidgogishvili.projects.marketshop.Coordinates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordinates")
public class DistanceBetweenCoordinates {

    private final CoordinatesRepo coordinatesRepo;

    @Autowired
    public DistanceBetweenCoordinates(CoordinatesRepo coordinatesRepo) {
        this.coordinatesRepo = coordinatesRepo;
    }


    @GetMapping("/distance")
    public double getDistance() {
        List <Coordinate> coordinates = coordinatesRepo.findAll();
        if (coordinates.size() >=2) {
            Coordinate firstCoordinate = coordinates.get(0);
            Coordinate secondCoordinate = coordinates.get(1);
            return distance(firstCoordinate.getLatitude(), secondCoordinate.getLatitude(), firstCoordinate.getLongtitude(), secondCoordinate.getLongtitude());
        } else {
            return 0.0;
        }
    }
   public double distance (double lat1, double lat2, double lon1, double lon2) {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.tan(lat2);

        double dlon = lon2-lon1;
        double dlat = lat2-lat1;
        double a = Math.pow(Math.sin(dlat/2),2) + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(dlon/2),2);

        double c = 2*Math.asin(Math.sqrt(a));

        double r = 6371;

        return (c*r);
    }

}
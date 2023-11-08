package ge.davidgogishvili.projects.marketshop.Coord;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordController {

    private final CoordService coordService;

    public CoordController(CoordService coordService) {
        this.coordService = coordService;
    }

    @PostMapping("/CoordStore")
    public String storeCoords (@RequestBody CoordRequest request){
        coordService.storeCoords(request);
        return "გადმოეცა, ეგარი!";
    }
}

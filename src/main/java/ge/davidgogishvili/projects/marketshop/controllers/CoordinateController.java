package ge.davidgogishvili.projects.marketshop.controllers;

import ge.davidgogishvili.projects.marketshop.entities.Coordinate;
import ge.davidgogishvili.projects.marketshop.services.CoordinateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("coordinates")
public class CoordinateController {


    private CoordinateService coordinateService;
    @PostMapping("/uploadExcel")
    public ResponseEntity <?> uploadCoordinates(@RequestParam("file")MultipartFile file){
        this.coordinateService.saveCoordinatesToDatabase(file);
        return ResponseEntity.ok(Map.of("Message", "არიქა ბიჯო, ეიტვირთა!"));
    }

    @GetMapping
    public ResponseEntity <List<Coordinate>> getCoordinates () {
        return new ResponseEntity<>(coordinateService.getCoordinates(), HttpStatus.FOUND);
    }

}

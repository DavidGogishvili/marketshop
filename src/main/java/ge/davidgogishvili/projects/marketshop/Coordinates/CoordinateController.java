package ge.davidgogishvili.projects.marketshop.Coordinates;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("files/upload")
public class CoordinateController {


    private CoordinateService coordinateService;
    @PostMapping("/uploadExcel")
    @Operation(tags = "File Management", summary = "ექსელის ფაილის ატვირთვა")

    public ResponseEntity <?> uploadCoordinates(@RequestParam("file")MultipartFile file){
        this.coordinateService.saveCoordinatesToDatabase(file);
        return ResponseEntity.ok(Map.of("Message", "არიქა ბიჯო, ეიტვირთა!"));
    }

    @GetMapping("/getCootdinates")
    @Operation(tags = "Coordinates", summary = "ატვირთული ექსელ ფაილიდან მასალების ამოღება და ბაზაში ატვირთვა ცალკე ცხრილად (ამ შემთხვევაში კოორდინატებზე მაქვს გაკეთებული)")

    public ResponseEntity <List<Coordinate>> getCoordinates () {
        return new ResponseEntity<>(coordinateService.getCoordinates(), HttpStatus.FOUND);
    }

}

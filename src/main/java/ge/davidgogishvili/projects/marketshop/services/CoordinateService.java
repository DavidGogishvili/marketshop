package ge.davidgogishvili.projects.marketshop.services;

import ge.davidgogishvili.projects.marketshop.entities.Coordinate;
import ge.davidgogishvili.projects.marketshop.repositories.CoordinatesRepo;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CoordinateService {

    private CoordinatesRepo coordinatesRepo;

    public void saveCoordinatesToDatabase (MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Coordinate> coordinates = ExcelUploadService.getCoordinatesDataFromExcel(file.getInputStream());
                this.coordinatesRepo.saveAll(coordinates);
            } catch (IOException e) {
                try {
                    throw new IllegalAccessException("The file is not valid");
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    public List<Coordinate> getCoordinates(){
        return coordinatesRepo.findAll();
    }
}

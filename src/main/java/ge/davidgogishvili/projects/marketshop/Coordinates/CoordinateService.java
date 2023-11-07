package ge.davidgogishvili.projects.marketshop.Coordinates;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CoordinateService {

    private CoordinatesRepo coordinatesRepo;

    public void saveCoordinatesToDatabase (MultipartFile file) {
        if (CoordinateUploadService.isValidExcelFile(file)) {
            try {
                List<Coordinate> coordinates = CoordinateUploadService.getCoordinatesDataFromExcel(file.getInputStream());
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
}
package ge.davidgogishvili.projects.marketshop.services;

import ge.davidgogishvili.projects.marketshop.Coordinates.Coordinate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file) {


        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    }

    public static List <Coordinate> getCoordinatesDataFromExcel(InputStream inputStream) throws IOException {
        List<Coordinate> coordinates = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("coordinates");

            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex ==0) {
                    rowIndex ++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                                Coordinate coordinate = new Coordinate();

                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0  -> coordinate.setId((int) cell.getNumericCellValue());
                        case 1 -> coordinate.setLongtitude(cell.getNumericCellValue());
                        case 2 -> coordinate.setLatitude(cell.getNumericCellValue());
                        default ->  {

                        }
                    }
                    cellIndex ++;
                }
                coordinates.add(coordinate);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return coordinates;
    }

}

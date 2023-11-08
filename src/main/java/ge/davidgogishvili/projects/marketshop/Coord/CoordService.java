package ge.davidgogishvili.projects.marketshop.Coord;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CoordService {

    private final HistoryRepo historyRepo;
    private final CurrentRepo currentRepo;

    public CoordService(HistoryRepo histotyrepo, CurrentRepo currentRepo) {
        this.historyRepo = histotyrepo;
        this.currentRepo = currentRepo;
    }

    public void  storeCoords(CoordRequest request) {

        CoordHistory coordHistory = new CoordHistory(request.getNumber(), request.getLatitude(), request.getLongtitude(), request.getLast_contact_date());
        CurrentCoord currentCoord = new CurrentCoord(request.getNumber(), request.getLatitude(), request.getLongtitude(), request.getLast_contact_date());

        historyRepo.save(coordHistory);
        currentRepo.save(currentCoord);

    }
}

import org.code.models.TravelAgency;
import org.code.models.TravelPackage;
import org.code.service.TravelAgencyService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class TravelAgencyServiceTest {

    @Test
    void testCreateTravelAgency() {
        TravelAgencyService service = new TravelAgencyService();
        List<TravelPackage> packages = new ArrayList<>();
        packages.add(new TravelPackage("Package 1", 10)); // Example passenger capacity
        packages.add(new TravelPackage("Package 2", 15)); // Example passenger capacity
        packages.add(new TravelPackage("Package 3", 20)); // Example passenger capacity

        TravelAgency agency = service.createTravelAgency(packages);

        assertEquals(3, agency.getPackages().size());
    }

    @Test
    void testAddTravelPackage() {
        TravelAgencyService service = new TravelAgencyService();
        TravelAgency agency = new TravelAgency();
        List<TravelPackage> packages = new ArrayList<>();
        packages.add(new TravelPackage("Package 1", 10)); // Example passenger capacity
        packages.add(new TravelPackage("Package 2", 15)); // Example passenger capacity
        packages.add(new TravelPackage("Package 3", 20)); // Example passenger capacity

        service.addTravelPackage(agency, packages);

        assertEquals(3, agency.getPackages().size());
    }
}
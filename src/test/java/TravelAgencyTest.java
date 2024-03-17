import org.code.models.TravelAgency;
import org.code.models.TravelPackage;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TravelAgencyTest {

    @Test
    public void testAddTravelPackage() {
        TravelAgency travelAgency = new TravelAgency();
        TravelPackage travelPackage1 = new TravelPackage("Package 1",20);
        TravelPackage travelPackage2 = new TravelPackage("Package 2",10);

        travelAgency.addTravelPackage(travelPackage1);
        travelAgency.addTravelPackage(travelPackage2);

        List<TravelPackage> packages = travelAgency.getPackages();
        assertEquals(2, packages.size());
        assertTrue(packages.contains(travelPackage1));
        assertTrue(packages.contains(travelPackage2));
    }

    @Test
    public void testEmptyTravelAgency() {
        TravelAgency travelAgency = new TravelAgency();
        List<TravelPackage> packages = travelAgency.getPackages();

        assertTrue(packages.isEmpty());
    }
}

import org.code.enums.PassengerType;
import org.code.models.Destination;
import org.code.models.Passenger;
import org.code.models.TravelPackage;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TravelPackageTest {

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        Destination paris = new Destination("Paris");
        Destination rome = new Destination("Rome");

        travelPackage.addDestination(paris);
        travelPackage.addDestination(rome);

        List<Destination> itinerary = travelPackage.getItinerary();
        assertEquals(2, itinerary.size());
        assertTrue(itinerary.contains(paris));
        assertTrue(itinerary.contains(rome));
    }

    @Test
    public void testAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        Passenger passenger1 = new Passenger("John Doe", 12345, PassengerType.STANDARD, 100.0);
        Passenger passenger2 = new Passenger("Jane Smith", 67890, PassengerType.GOLD, 200.0);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        List<Passenger> passengers = travelPackage.getPassengers();
        assertEquals(2, passengers.size());
        assertTrue(passengers.contains(passenger1));
        assertTrue(passengers.contains(passenger2));
    }
}
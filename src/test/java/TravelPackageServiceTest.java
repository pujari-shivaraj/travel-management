import org.code.enums.PassengerType;
import org.code.service.TravelPackageService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.code.models.Activity;
import org.code.models.Destination;
import org.code.models.Passenger;

import org.code.models.TravelPackage;

public class TravelPackageServiceTest {

    @Test
    public void testBookActivityAvailableActivity() {
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);
        Passenger passenger = new Passenger("John Doe", 12345, PassengerType.STANDARD, 100.0);

        TravelPackageService travelPackageService = new TravelPackageService();
        travelPackageService.bookActivity(travelPackage, activity, passenger);

        assertEquals(1, travelPackage.getBookings().size());
        assertTrue(travelPackage.getBookings().containsKey(activity));
        assertTrue(travelPackage.getBookings().get(activity).contains(passenger));
    }

    @Test
    public void testBookActivityFullyBookedActivity() {
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 1, destination);
        Passenger passenger1 = new Passenger("John Doe", 12345, PassengerType.STANDARD, 100.0);
        Passenger passenger2 = new Passenger("Jane Smith", 67890, PassengerType.GOLD, 200.0);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        TravelPackageService travelPackageService = new TravelPackageService();
        travelPackageService.bookActivity(travelPackage, activity, passenger1);
        travelPackageService.bookActivity(travelPackage, activity, passenger2); // Try to book for second passenger

        assertEquals(1, travelPackage.getBookings().size());
        assertTrue(travelPackage.getBookings().containsKey(activity));
        assertEquals(1, travelPackage.getBookings().get(activity).size());
        assertTrue(travelPackage.getBookings().get(activity).contains(passenger1));
        assertFalse(travelPackage.getBookings().get(activity).contains(passenger2));
    }

    @Test
    public void testPrintPassengerList() {
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        Passenger passenger1 = new Passenger("John Doe", 12345, PassengerType.STANDARD, 100.0);
        Passenger passenger2 = new Passenger("Jane Smith", 67890, PassengerType.GOLD, 200.0);

        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        TravelPackageService travelPackageService = new TravelPackageService();
        travelPackageService.printPassengerList(travelPackage);
    }

    @Test
    public void testPrintItinerary() {
        TravelPackage travelPackage = new TravelPackage("Europe Trip", 10);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);

        TravelPackageService travelPackageService = new TravelPackageService();
        travelPackageService.printItinerary(travelPackage);
    }
}
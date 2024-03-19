import org.code.enums.PassengerType;
import org.code.models.Activity;
import org.code.models.Destination;
import org.code.models.Passenger;
import org.code.models.TravelPackage;
import org.code.service.TravelPackageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TravelPackageServiceTest {

    private TravelPackageService travelPackageService;

    @BeforeEach
    void setUp() {
        travelPackageService = new TravelPackageService();
    }

    @Test
    void testBookActivity_StandardPassenger_Success() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Destination 1");
        Activity activity = new Activity("Activity 1", "Description", 100.0, 10, destination);
        Passenger passenger = new Passenger("John", 123, PassengerType.STANDARD, 500.0);

        // When
        travelPackageService.bookActivity(travelPackage, activity, passenger);

        // Then
        assertTrue(travelPackage.getBookings().containsKey(activity));
        assertTrue(travelPackage.getBookings().get(activity).contains(passenger));
    }

    @Test
    void testBookActivity_GoldPassenger_Success() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Destination 1");
        Activity activity = new Activity("Activity 1", "Description", 100.0, 10, destination);
        Passenger passenger = new Passenger("Alice", 456, PassengerType.GOLD, 1000.0);

        // When
        travelPackageService.bookActivity(travelPackage, activity, passenger);

        // Then
        assertTrue(travelPackage.getBookings().containsKey(activity));
        assertTrue(travelPackage.getBookings().get(activity).contains(passenger));
    }

    @Test
    void testBookActivity_PremiumPassenger_Success() {
        // Given
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);
        Destination destination = new Destination("Destination 1");
        Activity activity = new Activity("Activity 1", "Description", 100.0, 10, destination);
        Passenger passenger = new Passenger("Bob", 789, PassengerType.PREMIUM, 2000.0);

        // When
        travelPackageService.bookActivity(travelPackage, activity, passenger);

        // Then
        assertTrue(travelPackage.getBookings().containsKey(activity));
        assertTrue(travelPackage.getBookings().get(activity).contains(passenger));
    }
}

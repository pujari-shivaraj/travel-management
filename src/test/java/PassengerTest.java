import org.code.enums.PassengerType;
import org.code.models.Activity;
import org.code.models.ActivityBooking;
import org.code.models.Destination;
import org.code.models.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PassengerTest {

    @Test
    public void testPassengerConstructorAndGetters() {
        PassengerType type = PassengerType.STANDARD;
        Passenger passenger = new Passenger("John Doe", 12345, type, 100.0);

        assertEquals("John Doe", passenger.getName());
        assertEquals(12345, passenger.getPassengerNumber());
        assertEquals(type, passenger.getType());
        assertEquals(100.0, passenger.getBalance());
        assertTrue(passenger.getActivityBookings().isEmpty());
    }

    @Test
    public void testSetBalance() {
        Passenger passenger = new Passenger("Jane Smith", 67890, PassengerType.GOLD, 200.0);
        passenger.setBalance(300.0);
        assertEquals(300.0, passenger.getBalance());
    }

    @Test
    public void testAddActivityBooking() {
        Destination destination = new Destination("Destination 1");
        Passenger passenger = new Passenger("Alice Johnson", 13579, PassengerType.PREMIUM, 150.0);
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);
        destination.addActivity(activity);
        ActivityBooking activityBooking = new ActivityBooking(activity, 50.0);

        passenger.addActivityBooking(activityBooking);

        List<ActivityBooking> bookings = passenger.getActivityBookings();
        assertEquals(1, bookings.size());
        assertEquals(activityBooking, bookings.get(0));
    }
}
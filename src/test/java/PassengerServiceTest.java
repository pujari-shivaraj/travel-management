import org.code.enums.PassengerType;
import org.code.models.Activity;
import org.code.models.Destination;
import org.code.models.Passenger;
import org.code.service.PassengerService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PassengerServiceTest {

    @Test
    public void testBookActivityStandardPassengerSufficientBalance() {
        Passenger passenger = new Passenger("John Doe", 12345, PassengerType.STANDARD, 100.0);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);

        PassengerService passengerService = new PassengerService();
        passengerService.bookActivity(passenger, activity);

        assertEquals(50.0, passenger.getBalance(), 0.001);
        assertEquals(1, passenger.getActivityBookings().size());
        assertEquals(activity, passenger.getActivityBookings().get(0).getActivity());
        assertEquals(50.0, passenger.getActivityBookings().get(0).getPrice(), 0.001);
    }

    @Test
    public void testBookActivityStandardPassengerInsufficientBalance() {
        Passenger passenger = new Passenger("John Doe", 12345, PassengerType.STANDARD, 40.0);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);

        PassengerService passengerService = new PassengerService();
        passengerService.bookActivity(passenger, activity);

        assertEquals(40.0, passenger.getBalance(), 0.001);
        assertTrue(passenger.getActivityBookings().isEmpty());
    }

    @Test
    public void testBookActivityGoldPassengerSufficientBalance() {
        Passenger passenger = new Passenger("Jane Smith", 67890, PassengerType.GOLD, 100.0);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);

        PassengerService passengerService = new PassengerService();
        passengerService.bookActivity(passenger, activity);

        assertEquals(45.0, passenger.getBalance(), 0.001);
        assertEquals(1, passenger.getActivityBookings().size());
        assertEquals(activity, passenger.getActivityBookings().get(0).getActivity());
        assertEquals(50.0, passenger.getActivityBookings().get(0).getPrice(), 0.001);
    }

    @Test
    public void testBookActivityGoldPassengerInsufficientBalance() {
        Passenger passenger = new Passenger("Jane Smith", 67890, PassengerType.GOLD, 40.0);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);

        PassengerService passengerService = new PassengerService();
        passengerService.bookActivity(passenger, activity);

        assertEquals(40.0, passenger.getBalance(), 0.001);
        assertTrue(passenger.getActivityBookings().isEmpty());
    }

    @Test
    public void testBookActivityPremiumPassenger() {
        Passenger passenger = new Passenger("Alice Johnson", 13579, PassengerType.PREMIUM, 100.0);
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Sightseeing Tour", "Visit famous landmarks", 50.0, 20, destination);

        PassengerService passengerService = new PassengerService();
        passengerService.bookActivity(passenger, activity);

        assertEquals(100.0, passenger.getBalance(), 0.001);
        assertEquals(1, passenger.getActivityBookings().size());
        assertEquals(activity, passenger.getActivityBookings().get(0).getActivity());
        assertEquals(0, passenger.getActivityBookings().get(0).getPrice(), 0.001);
    }
}

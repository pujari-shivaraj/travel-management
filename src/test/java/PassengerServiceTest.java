import org.code.enums.PassengerType;
import org.code.models.Activity;
import org.code.models.ActivityBooking;
import org.code.models.Destination;
import org.code.models.Passenger;
import org.code.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceTest {

    private PassengerService passengerService;
    private Passenger standardPassenger;
    private Passenger goldPassenger;
    private Passenger premiumPassenger;

    @BeforeEach
    void setUp() {
        passengerService = new PassengerService();

        Destination cityDestination = new Destination("City");
        Destination mountainDestination = new Destination("Mountain");

        standardPassenger = new Passenger("John", 123, PassengerType.STANDARD, 100.0);
        goldPassenger = new Passenger("Jane", 456, PassengerType.GOLD, 200.0);
        premiumPassenger = new Passenger("Alice", 789, PassengerType.PREMIUM, 500.0);
    }

    @Test
    void updateBalance() {
        passengerService.updateBalance(standardPassenger, 150.0);
        assertEquals(150.0, standardPassenger.getBalance());
    }

    @Test
    void addActivityBooking() {
        Activity activity = new Activity("Hiking", "Enjoy hiking", 20.0, 10, new Destination("Mountain"));
        ActivityBooking activityBooking = new ActivityBooking(activity, 20.0);
        passengerService.addActivityBooking(standardPassenger, activityBooking);

        List<ActivityBooking> bookings = standardPassenger.getActivityBookings();
        assertEquals(1, bookings.size());
        assertEquals(activityBooking, bookings.get(0));
    }

    @Test
    void bookActivity_standardPassenger_sufficientBalance() {
        Activity activity = new Activity("Sightseeing", "Tour around the city", 50.0, 10, new Destination("City"));
        passengerService.bookActivity(standardPassenger, activity);

        assertEquals(50.0, standardPassenger.getBalance());
        assertEquals(1, standardPassenger.getActivityBookings().size());
        assertEquals(1, activity.getBooked());
    }

    @Test
    void bookActivity_standardPassenger_insufficientBalance() {
        Activity expensiveActivity = new Activity("Skydiving", "Experience skydiving", 500.0, 5, new Destination("Sky"));
        passengerService.bookActivity(standardPassenger, expensiveActivity);

        assertEquals(100.0, standardPassenger.getBalance());
        assertEquals(0, standardPassenger.getActivityBookings().size());
        assertEquals(0, expensiveActivity.getBooked());
    }

    @Test
    void bookActivity_goldPassenger_discountApplied() {
        Activity activity = new Activity("Boating", "Enjoy boating", 100.0, 8, new Destination("Lake"));
        passengerService.bookActivity(goldPassenger, activity);

        assertEquals(180.0, goldPassenger.getBalance());
        assertEquals(1, goldPassenger.getActivityBookings().size());
        assertEquals(1, activity.getBooked());
    }

    @Test
    void bookActivity_goldPassenger_insufficientBalance() {
        Activity expensiveActivity = new Activity("Paragliding", "Experience paragliding", 300.0, 6, new Destination("Sky"));
        passengerService.bookActivity(goldPassenger, expensiveActivity);

        assertEquals(200.0, goldPassenger.getBalance());
        assertEquals(0, goldPassenger.getActivityBookings().size());
        assertEquals(0, expensiveActivity.getBooked());
    }

    @Test
    void bookActivity_premiumPassenger_freeBooking() {
        Activity activity = new Activity("Museum Tour", "Explore museum", 50.0, 15, new Destination("Town"));
        passengerService.bookActivity(premiumPassenger, activity);

        assertEquals(500.0, premiumPassenger.getBalance());
        assertEquals(1, premiumPassenger.getActivityBookings().size());
        assertEquals(1, activity.getBooked());
    }

    @Test
    void printPassengerDetails_noBookings() {
        String expectedOutput = "Passenger Name: John\n" +
                "Passenger Number: 123\n" +
                "Balance: $100.0\n" +
                "No activities booked.";
        assertEquals(expectedOutput, getPrintedOutput(standardPassenger));
    }

    @Test
    void printPassengerDetails_withBookings() {
        Activity activity1 = new Activity("Hiking", "Enjoy hiking", 20.0, 10, new Destination("Mountain"));
        ActivityBooking booking1 = new ActivityBooking(activity1, 20.0);
        standardPassenger.getActivityBookings().add(booking1);

        Activity activity2 = new Activity("Sightseeing", "Tour around the city", 50.0, 10, new Destination("City"));
        ActivityBooking booking2 = new ActivityBooking(activity2, 50.0);
        standardPassenger.getActivityBookings().add(booking2);

        String expectedOutput = "Passenger Name: John\n" +
                "Passenger Number: 123\n" +
                "Balance: $100.0\n" +
                "Activities Booked:\n" +
                "- Activity: Hiking\n" +
                "  Destination: Mountain\n" +
                "  Price Paid: $20.0\n" +
                "- Activity: Sightseeing\n" +
                "  Destination: City\n" +
                "  Price Paid: $50.0";
        assertEquals(expectedOutput, getPrintedOutput(standardPassenger));
    }

    // Helper method to capture printed output
    private String getPrintedOutput(Passenger passenger) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        passengerService.printPassengerDetails(passenger);
        return outputStream.toString().trim();
    }
}

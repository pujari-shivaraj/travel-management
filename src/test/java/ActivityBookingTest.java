import org.code.models.Activity;
import org.code.models.ActivityBooking;
import org.code.models.Destination;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActivityBookingTest {

    @Test
    void testConstructorInitialization() {
        Activity activity = new Activity("Hiking", "Mountain trekking", 50.0, 10, new Destination("Mountains"));
        ActivityBooking activityBooking = new ActivityBooking(activity, 50.0);
        
        assertEquals(activity, activityBooking.getActivity());
        assertEquals(50.0, activityBooking.getPrice());
    }
}
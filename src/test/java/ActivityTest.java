import static org.junit.Assert.*;

import org.code.models.Activity;
import org.code.models.Destination;
import org.junit.Test;

public class ActivityTest {

    @Test
    public void testBookActivity() {
        Activity activity = new Activity("Hiking", "Enjoy a scenic hike", 25.0, 10, new Destination("Mountain"));
        assertTrue(activity.isAvailableToBook());
        activity.book();
        assertEquals(1, activity.getBooked());
    }

    @Test
    public void testActivityAvailability() {
        Activity activity = new Activity("Sightseeing Tour", "Explore the city landmarks", 50.0, 20, new Destination("City"));
        for (int i = 0; i < 20; i++) {
            activity.book();
        }
        assertFalse(activity.isAvailableToBook());
    }

    @Test
    public void testActivityCapacity() {
        Activity activity = new Activity("Boat Tour", "Enjoy a boat ride", 30.0, 15, new Destination("Beach"));
        for (int i = 0; i < 14 ; i++) {
            activity.book();
        }
        assertTrue(activity.isAvailableToBook());
        activity.book();
        assertFalse(activity.isAvailableToBook());
        assertEquals(15, activity.getBooked());
    }

    @Test
    public void testActivityDescription() {
        Activity activity = new Activity("Cultural Tour", "Learn about local traditions", 40.0, 25, new Destination("Historical Site"));
        assertEquals("Learn about local traditions", activity.getDescription());
    }
}
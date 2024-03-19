

import org.code.models.Activity;
import org.code.models.Destination;
import org.code.service.ActivityService;
import org.code.service.DestinationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityServiceTest {

    private ActivityService activityService;
    private DestinationService destinationService;

    @BeforeEach
    public void setUp() {
        destinationService = new DestinationService();
        activityService = new ActivityService();
    }

    @Test
    public void testCreateActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = activityService.createActivity("Test Activity", "Test Description", 100.0, 10, destination);
        
        assertNotNull(activity);
        assertEquals("Test Activity", activity.getName());
        assertEquals("Test Description", activity.getDescription());
        assertEquals(100.0, activity.getCost());
        assertEquals(10, activity.getCapacity());
        assertEquals(destination, activity.getDestination());
    }

    @Test
    public void testBookActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 100.0, 10, destination);
        
        activityService.book(activity);
        
        assertEquals(1, activity.getBooked());
    }

    @Test
    public void testIsAvailableToBook() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 100.0, 10, destination);
        
        assertTrue(activityService.isAvailableToBook(activity));
        
        activity.setBooked(10);
        
        assertFalse(activityService.isAvailableToBook(activity));
    }
}

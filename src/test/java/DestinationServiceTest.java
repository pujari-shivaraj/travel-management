

import org.code.models.Activity;
import org.code.models.Destination;
import org.code.service.DestinationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DestinationServiceTest {

    private DestinationService destinationService;

    @BeforeEach
    public void setUp() {
        destinationService = new DestinationService();
    }

    @Test
    public void testCreateDestination() {
        String destinationName = "Test Destination";
        Destination destination = destinationService.createDestination(destinationName);

        assertNotNull(destination);
        assertEquals(destinationName, destination.getName());
    }

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 100.0, 10, destination);

        destinationService.addActivity(destination, activity);

        List<Activity> activities = destination.getActivities();
        assertNotNull(activities);
        assertEquals(1, activities.size());
        assertEquals(activity, activities.get(0));
    }
}

import org.code.models.Activity;
import org.code.models.Destination;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DestinationTest {

    @Test
    void testAddActivity() {
        Destination destination = new Destination("Mountains");
        Activity activity = new Activity("Hiking", "Mountain trekking", 50.0, 10, destination);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
    }
}
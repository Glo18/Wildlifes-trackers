import org.junit.Test;
import static org.junit.Assert.*;

public class SightingsTest {

    @Test
    public void Sighting_location_true_string(){
        Sightings testSightings = new Sightings("Zone B", "Kayle", "rhino");
        assertEquals("Zone B", testSightings.getLocation());
    }

    @Test
    public void save_successfully_List() {
        Sightings testSightings = new Sightings("Zone A", "Maya", "koala");;
        testSightings.save();
        assertTrue(Endagered.getAllEndagered().get(0).equals(testSightings));
    }


}
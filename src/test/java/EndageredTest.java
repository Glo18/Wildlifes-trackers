import org.junit.*;

import static org.junit.Assert.assertEquals;

public class EndageredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endagered_instantiatesCorrectly_true() {
        Endagered testEndagered = new Endagered("Rhino", "okay", "Newborn");
        assertEquals(true, testEndagered instanceof Endagered);
    }

    @Test
    public void endagered_instantiatesWithName_String() {
        Endagered testEndagered = new Endagered("Rhino","okay", "Newborn");
        assertEquals("Rhino", testEndagered.getName());
    }

}
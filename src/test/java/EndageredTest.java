import org.junit.*;

import static org.junit.Assert.*;

public class EndageredTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Animals_instantiatesName_of_the_animal_true_String() {
        Endagered testEndagered = new Endagered("Rhino", "okay", "Newborn");
        assertEquals("Elephant", testEndagered.getName());
    }

    @Test
    public void save_successfully_List() {
        Endagered testEndagered = new Endagered("Rhino","okay", "Newborn");
        testEndagered.save();
        assertTrue(Endagered.getAllEndagered().get(0).equals(testEndagered));
    }

}
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalsTest  {

//    @Rule
//    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Animals_instantiatesName_of_the_animal_true_String() {
        Animals testAnimals = new Animals("Elephant");
        assertEquals("Elephant", testAnimals.getName());
    }

    @Test
    public void save_successfully_List() {
        Animals testAnimals = new Animals("Elephant");
        testAnimals.save();
        assertTrue(Endagered.getAllEndagered().get(0).equals(testAnimals));
    }


}
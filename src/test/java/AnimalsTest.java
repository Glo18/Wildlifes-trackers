import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalsTest  {

    @Test
    public void animals_instantiatesCorrectly_true(){
        Animals testAnimals = new Animals("Elephant", 1);
        assertEquals(true, testAnimals instanceof Animals);
    }

    @Test
    public void getName_animalsInstantiatesWithName_Elephant() {
        Animals testAnimals = new Animals("Elephant", 1);
        assertEquals("Elephant", testAnimals.getName());
    }

    @Test
    public void getId_animalsInstantiatesWithId_Elephant() {
        Animals testAnimals = new Animals("Elephant", 1);
        assertEquals(1, testAnimals.getId());
    }

}
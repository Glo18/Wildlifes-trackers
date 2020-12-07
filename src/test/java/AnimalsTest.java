import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void equals_returnsTrueIfNameAndIdAreSame_true() {
        Animals fisrtAnimals = new Animals("Elephant", 1);
        Animals anotherAnimals = new Animals("Elephant", 1);
        assertTrue(fisrtAnimals.equals(anotherAnimals));
    }

}
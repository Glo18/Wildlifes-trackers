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
        Animals firstAnimals = new Animals("Elephant", 1);
        Animals anotherAnimals = new Animals("Elephant", 1);
        assertTrue(firstAnimals.equals(anotherAnimals));
    }

    @Test
    public void save_AnimalsIntoDatabase_Animals() {
        Animals testAnimals = new Animals("Elephant", 1);
        testAnimals.save();
        assertTrue(Animals.all().get(0).equals(testAnimals));
    }

}
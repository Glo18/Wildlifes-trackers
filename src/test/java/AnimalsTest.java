import org.junit.Rule;
import org.junit.Test;
import org.junit.Rule;


import static org.junit.Assert.*;

public class AnimalsTest  {

    @Rule
    public DatabaseRule database = new DatabaseRule();

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

//    @Test
//    public void getId_animalsInstantiatesWithId_Elephant() {
//        Animals testAnimals = new Animals("Elephant", 1);
//        assertEquals(1, testAnimals.getId());
//    }

    @Test
    public void equals_returnsTrueIfNameAndIdAreSame_true() {
        Animals firstAnimal = new Animals("Elephant", 1);
        Animals anotherAnimal = new Animals("Elephant", 1);
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_AnimalsIntoDatabase_Animals() {
        Animals testAnimals = new Animals("Elephant", 1);
        testAnimals.save();
        assertTrue(Animals.all().get(0).equals(testAnimals));
    }

    @Test
    public void all_returnsAllInstancesOfAnimals_true() {
        Animals firstAnimal = new Animals("Elephant", 1);
        firstAnimal.save();
        Animals secondAnimal = new Animals("Elephant", 1);
        secondAnimal.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimal));
        assertEquals(true, Animals.all().get(1).equals(secondAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        Animals testAnimals = new Animals("Elephant",1);
        testAnimals.save();
        Animals savedAnimals = Animals.all().get(0);
        assertEquals(testAnimals.getId(), savedAnimals.getId());
    }

    @Test
    public void find_returnsAnimalsWithSameId_secondAnimal() {
        Animals firstAnimal = new Animals("Elephant", 1);
        firstAnimal.save();
        Animals secondAnimal = new Animals("Elephant", 1);
        secondAnimal.save();
        assertEquals(Animals.find(secondAnimal.getId()), secondAnimal);
    }

}
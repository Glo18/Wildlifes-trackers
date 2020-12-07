public class Animals {
    private String name;
    private int id;

    public Animals(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherAnimals){
        if (!(otherAnimals instanceof Animals)) {
            return false;
        }else {
            Animals newAnimals = (Animals) otherAnimals;
            return this.getName().equals(newAnimals.getName()) &&
                    this.getId() == (newAnimals.getId());
        }
    }
}

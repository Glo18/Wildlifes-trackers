import java.sql.Connection;
import java.util.List;

import org.sql2o.*;

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

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Animals> all() {
        String sql = "SELECT * FROM persons";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }

        }
}

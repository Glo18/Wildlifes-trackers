import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Endagered implements DatabaseManagement {
    private int id;
    private String name;
    private String health;
    private String age;

    public static final String HEALTHY = "healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "okay";
    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";

    private static final String DATABASE_TYPE = "endangered";
    private String type;

    public Endagered(String name, String health, String age) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.age = age;
        this.setType(DATABASE_TYPE);
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth(){
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge(){
        return age;
    }

    public String getType() {
        return type;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }


    @Override
    public boolean equals(Object otherEndangered){
        if (!(otherEndangered instanceof Endagered)) {
            return false;
        } else {
            Endagered newEndangered = (Endagered) otherEndangered;
            return this.getName().equals(newEndangered.getName()) &&
                    this.getId() == newEndangered.getId();
        }
    }

    public static List<Endagered> getAllEndagered(){
        String sql = "SELECT * FROM animals WHERE type = 'endangered';";

        try (Connection con = DB.sql2o.open()){
            return   con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endagered.class);

        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, health, age) VALUES (:name, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }catch (Sql2oException ex ){
            System.out.println(ex);
        }
    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }catch (Sql2oException ex ){
            System.out.println(ex);
        }
    }
}

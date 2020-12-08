import javax.management.Query;
import java.sql.Connection;

public class Sightings {

    private int id;
    private String location;
    private String rangerName;
    private String animalName;

    public Sightings(String location, String rangerName, String animalName) {
        this.id = id;
        this.location = location;
        this.rangerName = rangerName;
        this.animalName = animalName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public static List<Sightings> getAllSightings(){
        String sql = "SELECT * FROM sightings;";

        try (Connection con = DB.sql2o.open()){
            Query query =con.createQuery(sql);
            System.out.println(query.executeAndFetch(Sightings.class));
            return query.executeAndFetch(Sightings.class);
        }
    }
}

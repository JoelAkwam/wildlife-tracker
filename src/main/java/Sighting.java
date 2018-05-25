import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;

public class Sighting{
    private String ranger;
    private String location;
    private int animal_id;
    private Timestamp timestamp;
    private int id;

    public Sighting (String ranger, String location, int animal_id){
        this.ranger = ranger;
        this.location = location;
        this.animal_id = animal_id;
    }

    public String getRanger(){
        return ranger;
    }
    public String getLocation(){
        return location;
    }
    public int getAnimalId(){
        return animal_id;
    }
    public Timestamp getTimestamp(){
        return timestamp;
    }
    public int getId(){
        return id;
    }
}
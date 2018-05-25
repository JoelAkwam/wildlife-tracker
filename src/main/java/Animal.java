import org.sql2o.*;
import java.util.List;

public class Animal{
    private String endangered;
    private String animal;
    private int id;
    
    public Animal(String animal, String endangered){
        this.endangered = endangered;
        this.animal = animal;
    }

    public String getEndangered(){
        return endangered;
    }

    public String getAnimal(){
        return animal;
    }
    public int getId(){
        return id;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals(animal, endangered) VALUES(:animal, :endangered)";
            this.id = (int) con.createQuery(sql, true)
            .addParameter("animal", this.animal)
            .addParameter("endangered", this.endangered)
            .throwOnMappingFailure(false);
            .executeUpdate()
            .getKey();

        }
    }
    
    public static List<Animal> all() {
        String sql = "select * from animals";
        try(Connection con = DB.sql2o.open()) {
           return con.createQuery(sql)
           .throwOnMappingFailure(false)
           .executeAndFetch(Animal.class);
        }
}

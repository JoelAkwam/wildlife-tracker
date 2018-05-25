import org.sql2o.*;
import java.util.List;

public class Animal{
    private String endangered;
    private String animal;
    private String health;
    private String age;
    private int id;
    
    public Animal(String animal, String endangered, String health, String age){
        this.animal = animal;
        this.endangered = endangered;
        this.health = health;
        this.age = age;
    }

    public String getEndangered(){
        return endangered;
    }

    public String getAnimal(){
        return animal;
    }
    public String health(){
        return health;
    }
    public String age(){
        return age;
    }
    public int getId(){
        return id;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals(animal, endangered, health, age) VALUES(:animal, :endangered, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
            .addParameter("animal", this.animal)
            .addParameter("endangered", this.endangered)
            .addParameter("health", this.health)
            .addParameter("age", this.age)
            .throwOnMappingFailure(false)
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
}


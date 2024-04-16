import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private String username;
    private String password;
    private String password;
    private String dl_info;
    private String make;
    private String model;
    private String color;
    private String plate_number;

    public User(String username, String password, String dl_info, String make, String model, String color, String plate_number) {
        this.username = username;
        this.password = password;
        this.dl_info = dl_info;
        this.make = make;
        this.model = model;
        this.color = color;
        this.plate_number = plate_number;
    }
    // other fields, getters, and setters
}
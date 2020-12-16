package person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private LocalDate birthday;
    private Float height;
    private String passportID;
    private Location location;

    public Person(String name,LocalDate birthday, Float height, String passportID, Location location) throws IllegalArgumentException, NullPointerException {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        } else {
            this.name=name;
        }
        if ( height >0 ){
            this.height = height;
        } else {
            throw new IllegalArgumentException("Invalid height");
        }
        this.location = Objects.requireNonNull(location,"invalid location");
        this.birthday =  Objects.requireNonNull(birthday,"invalid birthday");;
        if (passportID.length()>=35 || passportID.length()<7 || passportID == null ||passportID.isEmpty()){
            throw new IllegalArgumentException("Invalid passportID");
        } else {
            this.passportID = passportID;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Float getHeight() {
        return height;
    }

    public String getPassportID(){
        return passportID;
    }

    public Location getLocation(){
        return location;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setHeight(Float height) {
        this.height=height;
    }

    public void setPassportID(String passportID){
        this.passportID=passportID;
    }
}
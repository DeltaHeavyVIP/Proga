package person;

import java.io.Serializable;
import java.util.Objects;

public class Location implements Serializable {
    private Double x;
    private float y;
    private Integer z;
    private String name;

    public Location(Double x, float y, Integer z, String name) throws  IllegalArgumentException, NullPointerException {
        this.x = Objects.requireNonNull(x,"invalid x");
        this.y = y;
        this.z = Objects.requireNonNull(z,"invalid z");
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        } else {
            this.name=name;
        }
    }

    public Double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    public void setX(Double x) { this.x=x; }

    public void setY(float y) {
        this.y=y;
    }

    public void setZ(Integer z) { this.z=z;}

    public void setName(String name) {this.name=name;}
}
package dragon;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private int x;
    private Float y;

    public Coordinates(int x, Float y) throws IllegalArgumentException, NullPointerException {
        if (x <= 77) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("Invalid x");
        }
        if (y <= 927 || y != 0) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Invalid y");
        }
    }

    public Integer getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(Integer x){this.x=x;}

    public void setY(Float y){
        if (y <= 927 || y != 0) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("Invalid y");
        }
    }
}

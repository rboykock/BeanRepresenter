package pro.cherkassy.rboyko.beans;

import pro.cherkassy.rboyko.annotations.Value;

/**
 * Created by rboyko on 13.12.16.
 */
public class Car {
    protected String color;
    protected int maxSpeed;
    protected String type;
    protected String model;

    public Car(){

    }

    public Car(String color, int maxSpeed, String type, String model) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.type = type;
        this.model = model;
    }

    public String getColor() {
        return color;
    }
    @Value(val = "green",type = String.class)
    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    @Value(val = "180",type = Integer.class)
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getType() {
        return type;
    }

    @Value(val = "sedan",type = String.class)
    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    @Value(val = "VAZ 2107",type = String.class)
    public void setModel(String model) {
        this.model = model;
    }
}

package pro.cherkassy.rboyko.beans;

import pro.cherkassy.rboyko.annotations.Value;

/**
 * Created by rboyko on 13.12.16.
 */
public class Cat {
    protected String color;
    protected int age;
    protected int legCount;
    protected int fullLength;

    public Cat(){

    }

    public Cat(String color, int age, int legCount, int fullLength) {
        this.color = color;
        this.age = age;
        this.legCount = legCount;
        this.fullLength = fullLength;
    }

    public String getColor() {
        return color;
    }

    @Value(val = "black",type = String.class)
    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    @Value(val = "5",type = Integer.class)
    public void setAge(int age) {
        this.age = age;
    }

    public int getLegCount() {
        return legCount;
    }

    @Value(val = "4",type = Integer.class)
    public void setLegCount(int legCount) {
        this.legCount = legCount;
    }

    public int getFullLength() {
        return fullLength;
    }

    @Value(val = "35",type = Integer.class)
    public void setFullLength(int fullLength) {
        this.fullLength = fullLength;
    }
}




package pro.cherkassy.rboyko.beans;

import pro.cherkassy.rboyko.annotations.Value;

/**
 * Created by rboyko on 13.12.16.
 */
public class Human {
    protected int height;
    protected String gender;
    protected int age;
    protected int weight;

    public Human(){

    }

    public Human(int height, String gender, int age, int weight) {
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    @Value(val = "180",type = Integer.class)
    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    @Value(val = "male",type = String.class)
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    @Value(val = "35",type = Integer.class)
    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    @Value(val = "95",type = Integer.class)
    public void setWeight(int weight) {
        this.weight = weight;
    }
}

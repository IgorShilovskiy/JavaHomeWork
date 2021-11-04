package com.pb.shilovskiy.hw6;

import java.util.Objects;

public class Animal {

    private String food;
    private String location;

    public void makeNoise(){
        System.out.println(" шумит ");
    }

    public void eat(){
        System.out.println(" ест " + food);
    }

    public void sleep(){
        System.out.println(" спит ");
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }
    public Animal() {
        this.food = "unknown food";
        this.location = "unknown location";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(getFood(), animal.getFood()) && Objects.equals(getLocation(), animal.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFood(), getLocation());
    }

    @Override
    public String toString() {
        return "Животное " + location + ", " +
                "корм: " + food;
    }
}


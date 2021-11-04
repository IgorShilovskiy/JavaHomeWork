package com.pb.shilovskiy.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private String profession; // охранник, поводырь, карманный пес, охотник

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака лает");
    }

    @Override
    public void eat() {
        System.out.print("Собака");
        super.eat();
    }

    public Dog(String food, String location, String profession) {
        super(food, location);
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(getProfession(), dog.getProfession());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProfession());
    }

    @Override
    public String toString() {
        return  "Собака - " + getProfession() + ", " +
                getLocation() + " животное, " +
                "корм: " + getFood();
    }
}

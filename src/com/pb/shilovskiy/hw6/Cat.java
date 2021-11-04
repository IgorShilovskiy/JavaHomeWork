package com.pb.shilovskiy.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private boolean ratCather; // ловит крыс да/нет

    public boolean isRatCather() {
        return ratCather;
    }

    public void setRatCather(boolean ratCather) {
        this.ratCather = ratCather;
    }

    public Cat(String food, String location, boolean ratCather) {
        super (food, location);
        this.ratCather = ratCather;
    }

    @Override
    public void makeNoise() {
        System.out.println("Кот мяукает");
    }

    @Override
    public void eat() {
        System.out.print("Кот");
        super.eat();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return isRatCather() == cat.isRatCather();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isRatCather());
    }

    @Override
    public String toString() {
        if (ratCather){
            return "Кот - " + "крысолов, " +
                    getLocation() + " животное, " +
                    "корм: " + getFood();
        } else {
            return "Кот - " + "не крысолов, " +
                    getLocation() + " животное, " +
                    "корм: " + getFood();
        }
    }
}

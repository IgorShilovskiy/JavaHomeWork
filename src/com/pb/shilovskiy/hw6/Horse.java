package com.pb.shilovskiy.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private String usage; //скачки, работа в поле, ездовая лошадь, для красоты, не используется

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public Horse(String food, String location, String usage) {
        super(food, location);
        this.usage = usage;
    }

    @Override
    public void eat() {
        System.out.print("Лошадь");
        super.eat();
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь ржет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Horse horse = (Horse) o;
        return Objects.equals(getUsage(), horse.getUsage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUsage());
    }

    @Override
    public String toString() {
        return "Лошадь - " +
                getLocation() + " животное, " +
                "корм: " + getFood() + ", предназначение: " + getUsage();
    }
}

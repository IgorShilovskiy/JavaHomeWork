package com.pb.shilovskiy.hw6;

public class Veterinarian {

    private final String name;

    public void treatAnimal(Animal animal){
        System.out.println("На прием привели " + animal.getLocation() + " животное");
        System.out.println("Приготовьте " + animal.getFood() + " для его кормления");
    }

    public Veterinarian(String name) {
        this.name = name;
    }

    public void printName(){
        System.out.println("Прием ведет доктор " + name);
    }

    public Veterinarian() {
        name="unknown name";
    }
}

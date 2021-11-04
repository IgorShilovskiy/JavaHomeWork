package com.pb.shilovskiy.hw6;

public class Veterinarian {
    public void treatAnimal(Animal animal){
        System.out.println("На прием привели " + animal.getLocation() + " животное");
        System.out.println("Приготовьте " + animal.getFood() + " для его кормления");
    }

    public Veterinarian() {
    }
}

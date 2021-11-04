package com.pb.shilovskiy.hw6;

public class VetСlinic {

    public static void toSleep(Animal animal){
        System.out.println("Доктор вводит наркоз...");
        if (animal instanceof Cat) {
            System.out.print("Кот");
        }
        else{
            if (animal instanceof Dog) {
                System.out.print("Собака");
            }
            else {
                if (animal instanceof Horse) {
                    System.out.print("Лошадь");
                }
                else{
                    System.out.print("Животное");
                }
            }
        }
        animal.sleep();
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat ("Whiskas","домашнее", false);
        Cat cat2 = new Cat ("Полевая мышь","дикое", true);
        Cat cat3 = new Cat ("Sheba","домашнее", false);
        Dog dog1 = new Dog ("Pedigree", "домашнее", "поводырь");
        Dog dog2 = new Dog ("Кости", "дикое", "охранник");
        Dog dog3 = new Dog ("Дичь", "домашнее", "охотник");
        Horse horse1 = new Horse ("Трава", "дикое", "не используется человеком");
        Horse horse2 = new Horse ("Яблоки", "домашнее", "для красоты");
        Horse horse3 = new Horse ("Овес", "дикое", "для скачек");
        Animal animal = new Animal("Зерно ","дикое");

        Animal[] animals = new Animal[] {cat1, cat2, cat3, dog1, dog2, dog3, horse1, horse2, horse3, animal};


        cat1.eat();
        cat1.makeNoise();

        dog1.eat();
        dog1.makeNoise();

        horse1.eat();
        horse1.makeNoise();

        toSleep(cat1);
        toSleep(dog1);
        toSleep(horse1);
        toSleep(animal);

        Veterinarian veterinarian = new Veterinarian();
        veterinarian.treatAnimal(horse1);

        System.out.println(cat1.toString());
        System.out.println(dog1.toString());
        System.out.println(horse1.toString());
        System.out.println(animal.toString());

    }
}

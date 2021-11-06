package com.pb.shilovskiy.hw6;

import java.lang.reflect.Constructor;

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

    public static void listAnimals(Animal[] animals){
        System.out.println("В клинике обслуживаются следующие пациенты:");
        for (int i=0; i<animals.length; i++){
            System.out.println(i+1+ ". " + animals[i].toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Cat cat1 = new Cat ("Whiskas","домашнее", false);
        Cat cat2 = new Cat ("Полевая мышь","дикое", true);
        Cat cat3 = new Cat ("Sheba","домашнее", false);
        Dog dog1 = new Dog ("Pedigree", "домашнее", "поводырь");
        Dog dog2 = new Dog ("Кости", "дикое", "охранник");
        Dog dog3 = new Dog ("Дичь", "домашнее", "охотник");
        Horse horse1 = new Horse ("Трава", "дикое", "не используется человеком");
        Horse horse2 = new Horse ("Яблоки", "домашнее", "для красоты");
        Horse horse3 = new Horse ("Овес", "дикое", "для скачек");

        Animal[] animals = new Animal[] {cat1, cat2, cat3, dog1, dog2, dog3, horse1, horse2, horse3};

        listAnimals(animals);

        Class vetClazz = Class.forName("com.pb.shilovskiy.hw6.Veterinarian");


        // создание объекта через рефлексию
        Constructor constr = vetClazz.getConstructor(new Class[] {String.class});
        Object obj = constr.newInstance("профессор медицины Крузенштерн И.Ф.");
        if (obj instanceof Veterinarian) {
            ((Veterinarian) obj).printName();
            for (int i=0; i<animals.length; i++){
                System.out.print(i+1 + ". ");
                ((Veterinarian) obj).treatAnimal(animals[i]);
                toSleep(animals[i]);
                System.out.println("Доктор проводит операцию........... Операция прошла успешно");
                animals[i].makeNoise();
                animals[i].eat();
            }
        }

    }
}

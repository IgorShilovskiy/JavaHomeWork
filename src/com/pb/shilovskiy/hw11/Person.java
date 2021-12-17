package com.pb.shilovskiy.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Person{
    String name;
    LocalDate date_birthday;
    List<String> numbers;
    String adress;
    LocalDateTime date_modify;

    public Person() {
    }

    public Person(String name, LocalDate date_birthday, List<String> numbers, String adress, LocalDateTime date_modify) {
        this.name = name;
        this.date_birthday = date_birthday;
        this.numbers = numbers;
        this.adress = adress;
        this.date_modify = date_modify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_birthday() {
        return date_birthday;
    }

    public void setDate_birthday(LocalDate date_birthday) {
        this.date_birthday = date_birthday;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public LocalDateTime getDate_modify() {
        return date_modify;
    }

    public void setDate_modify(LocalDateTime date_modify) {
        this.date_modify = date_modify;
    }

    @Override
    public String toString() {
        return  "{ФИО - '" + name + '\'' +
                ", Дата рождения - " + date_birthday +
                ", Номера телефонов: " + numbers +
                ", Адрес проживания: '" + adress + '\'' +
                ", Дата и время редактирования: " + date_modify +
                '}';
    }

    public Person(Person other) {
        this(other.getName(),other.getDate_birthday(),other.getNumbers(),other.getAdress(),other.getDate_modify());
    }
}

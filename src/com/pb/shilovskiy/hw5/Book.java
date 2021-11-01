package com.pb.shilovskiy.hw5;

public class Book {
    private String name;
    private String author;
    private int year;

    public Book (){
        this.name = "unknown namebook";
        this.author = "unknown author";
        this.year = 0;
    }

    public Book (String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printBook (){
        System.out.println(name + " (автор: " + author + ", год издания: " + year + "г.)");
    }
}

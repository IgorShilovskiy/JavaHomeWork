package com.pb.shilovskiy.hw7;

public abstract class Clothes {
    private Size size;
    private float price;
    private String color;

    public Size getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }


    public Clothes(Size size, float price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }
}

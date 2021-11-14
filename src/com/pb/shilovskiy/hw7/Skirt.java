package com.pb.shilovskiy.hw7;

public class Skirt extends Clothes implements WomenClothes {

    @Override
    public void dressWomen() {
        System.out.println("Юбка, размер: " + getSize() + " (евро: " + getSize().getEuroSize() + ") " +  getSize().getDescription() +", цвет: " + getColor() + ", цена: " + getPrice() + " грн.");
    }

    public Skirt(Size size, float price, String color) {
        super(size, price, color);
    }
}
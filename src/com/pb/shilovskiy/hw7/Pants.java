package com.pb.shilovskiy.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    @Override
    public void dressMan() {
        System.out.println("Брюки, размер: " + getSize() + " (евро: " + getSize().getEuroSize() + ") " +  getSize().getDescription() +", цвет: " + getColor() + ", цена: " + getPrice() + " грн.");
    }

    @Override
    public void dressWomen() {
        System.out.println("Брюки, размер: " + getSize() + " (евро: " + getSize().getEuroSize() + ") " +  getSize().getDescription() +", цвет: " + getColor() + ", цена: " + getPrice() + " грн.");
    }

    public Pants(Size size, float price, String color) {
        super(size, price, color);
    }
}

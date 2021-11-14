package com.pb.shilovskiy.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    @Override
    public void dressMan() {
        System.out.println("Футболка, размер: " + getSize() + " (евро: " + getSize().getEuroSize() + ") " +  getSize().getDescription() +", цвет: " + getColor() + ", цена: " + getPrice() + " грн.");
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболка, размер: " + getSize() + " (евро: " + getSize().getEuroSize() + ") " +  getSize().getDescription() +", цвет: " + getColor() + ", цена: " + getPrice() + " грн.");
    }

    public Tshirt(Size size, float price, String color) {
        super(size, price, color);
    }
}

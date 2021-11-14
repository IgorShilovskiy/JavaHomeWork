package com.pb.shilovskiy.hw7;

public class Tie extends Clothes implements ManClothes {
    @Override
    public void dressMan() {
        System.out.println("Галстук, размер: " + getSize() + " (евро: " + getSize().getEuroSize() + ") " +  getSize().getDescription() +", цвет: " + getColor() + ", цена: " + getPrice() + " грн.");
    }

    public Tie(Size size, float price, String color) {
        super(size, price, color);
    }
}
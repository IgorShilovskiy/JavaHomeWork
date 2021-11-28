package com.pb.shilovskiy.hw10;

public class Main {
    public static void main(String[] args) {

        System.out.println("Массив Integer");
        NumBox<Integer> nb1 = new NumBox<>(5);
        nb1.set(0, new Integer(25));
        nb1.set(1, new Integer(11));
        nb1.set(2, new Integer(8));
        System.out.println("Первоначально инициализировано " + nb1.length() + " значений: ");
        System.out.println(nb1.toString());
        try {
            nb1.add(new Integer(6));
            nb1.add(new Integer(45));
            nb1.add(new Integer(2));
        }
        catch (Exception e) {
            System.out.println("Число не записано. Массив чисел полон");
        }
        System.out.println("Итоговый массив состоит из " + nb1.length() + " значений: ");
        System.out.println(nb1.toString());
        System.out.println("3-й элемент: "+ nb1.get(2));
        System.out.println("Сумма всех элементов массива: " + nb1.sum());
        System.out.println("Среднее значение: " + nb1.average());
        System.out.println("Максимальный элемент: " + nb1.max());






        System.out.println("Массив Double");
        NumBox<Double> nb2 = new NumBox<>(7);
        nb2.set(0, new Double(25.5));
        nb2.set(1, new Double(11.5));
        nb2.set(2, new Double(81.5));
        System.out.println("Первоначально инициализировано " + nb2.length() + " значений: ");
        System.out.println(nb2.toString());
        try {
            nb2.add(new Double(6.5));
            nb2.add(new Double(4.5));
            nb2.add(new Double(2.5));
        }
        catch (Exception e) {
            System.out.println("Число не записано. Массив чисел полон");
        }
        System.out.println("Итоговый массив состоит из " + nb2.length() + " значений: ");
        System.out.println(nb2.toString());
        System.out.println("4-й элемент: "+ nb2.get(3));
        System.out.println("Сумма всех элементов массива: " + nb2.sum());
        System.out.println("Среднее значение: " + nb2.average());
        System.out.println("Максимальный элемент: " + nb2.max());
    }
}

package com.pb.shilovskiy.hw13;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable{

    private final LinkedList<Integer> warehouse;
    private final int max;

    public Producer(LinkedList<Integer> warehouse, int max) {
        this.warehouse = warehouse;
        this.max = max;
    }

    public void run(){
         while (true) {
                 try {
                     synchronized (warehouse) {
                         Thread.sleep(1000);
                         if (warehouse.size() < max) {
                             int rand = new Random().nextInt(101);
                             warehouse.addLast(rand);
                             System.out.println("Производитель добавил элемент: " + rand);
                             warehouse.notify();
                         } else {
                             System.out.println("Производитель ожидает...");
                             warehouse.wait();
                         }
                     }
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
         }
    }
}

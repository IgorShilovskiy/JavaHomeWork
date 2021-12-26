package com.pb.shilovskiy.hw13;

import java.util.LinkedList;
import java.util.Random;

public class Consumer implements Runnable{
    private final LinkedList<Integer> warehouse;
    private final int max;

    public Consumer(LinkedList<Integer> warehouse, int max) {
        this.warehouse = warehouse;
        this.max = max;
    }

    public void run(){
        while (true) {
                try {
                    synchronized (warehouse) {
                        Thread.sleep(500);
                        if (warehouse.size() > 0) {
                            warehouse.getFirst();
                            System.out.println("Потребитель забрал элемент: " + warehouse.getFirst());
                            warehouse.removeFirst();
                            warehouse.notify();
                        } else {
                            System.out.println("Потребитель ожидает...");
                            warehouse.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

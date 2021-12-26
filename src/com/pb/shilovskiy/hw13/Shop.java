package com.pb.shilovskiy.hw13;


import java.util.LinkedList;

public class Shop {

    public static void main(String[] args) {


    LinkedList<Integer> warehouse = new LinkedList<Integer>();
    int max = 5;

    Producer producer = new Producer(warehouse,max);
    Thread threadProducer = new Thread(producer,"Producer");
    threadProducer.start();

        Consumer consumer = new Consumer(warehouse,max);
        Thread threadConsumer = new Thread(consumer,"Consumer");
        threadConsumer.start();

    }
}
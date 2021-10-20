package com.pb.shilovskiy.hw3;

import java.util.Scanner;
import java.util.Random;

public class Bingo {
    public static void main(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(101);
        int oper;
        int count = 0;
        String exit;
        Scanner Scan = new Scanner(System.in);
        System.out.println("Программа загадала целое число в диапазоне от 0 до 100");
        System.out.println("Попытаетесь угадать? Введите y или n");
        do {
            count++;
            exit = Scan.next();
            while (!exit.equals("y")) {
                if (exit.equals("n")) {
                    break;
                }
                System.out.println("Программа не понимает такой комманды");
                System.out.println("Введите y или n");
                exit = Scan.next();
            }
            if (exit.equals("n")) {
                System.out.println("Вы вышли из программы");
                break;
            } else {
                System.out.println("Введите целое число в диапазоне от 0 до 100");
                oper = Scan.nextInt();
                if (oper == rand){
                    System.out.println("Поздравляю, Вы угадали задуманное число " + rand + " за " + count + " попыток");
                    break;
                }
                if (oper>rand){
                    System.out.println("Вы не угадали. Загаданное число меньше " + oper);
                }
                else {
                    System.out.println("Вы не угадали. Загаданное число больше " + oper);
                }
                System.out.println("Будете продолжать угадывать? Введите Y или N");
            }
        }
        while (oper != rand) ;

    }

}

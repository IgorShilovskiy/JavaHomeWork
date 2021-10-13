package com.pb.shilovskiy.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int oper1;
        int oper2;
        String sign;
        Scanner Scan = new Scanner(System.in);
        System.out.println("Введите данные для калькулятора");
        System.out.print("Введите целое число 1: ");
        oper1 = Scan.nextInt();
        System.out.print("Введите целое число 2: ");
        oper2 = Scan.nextInt();
        System.out.print("Введите один из знаков: +, -, *, /: ");
        sign = Scan.next();

        System.out.println("Вы проводите операцию: " + oper1 + " " + sign + " " + oper2);
        switch (sign) {
            case "+":
                oper1 = oper1 + oper2;
                System.out.print("Результат Вашей операции: " + oper1);
                break;
            case "-":
                oper1 = oper1 - oper2;
                System.out.print("Результат Вашей операции: " + oper1);
                break;
            case "*":
                oper1 = oper1 * oper2;
                System.out.print("Результат Вашей операции: " + oper1);
                break;
            case "/":
                if (oper2 == 0)
                    System.out.print("Данная операция недопустима");
                else {
                    oper1 = oper1 / oper2;
                    System.out.print("Результат Вашей операции: " + oper1);
                }
                break;
                default:
                    System.out.print("Вы ввели неверные данные. Вычисление произвести невозможно");
                    }
                }


        }
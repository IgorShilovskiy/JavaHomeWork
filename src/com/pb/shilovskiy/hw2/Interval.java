package com.pb.shilovskiy.hw2;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int oper1;
        Scanner Scan = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        oper1 = Scan.nextInt();
        if (oper1 > 100)
            System.out.print("Введенное Вами число: " + oper1 + " не попадает ни в один из промежутков [0 -14] [15 - 35] [36 - 50] [51 - 100]");
        else if (oper1 >= 51)
            System.out.print("Введенное Вами число: " + oper1 + " попадает в промежуток [51 - 100]");
        else if (oper1 >= 36)
            System.out.print("Введенное Вами число: " + oper1 + " попадает в промежуток [36 - 50]");
        else if (oper1 >= 15)
            System.out.print("Введенное Вами число: " + oper1 + " попадает в промежуток [15 - 35]");
        else if (oper1 >= 0)
            System.out.print("Введенное Вами число: " + oper1 + " попадает в промежуток [0 - 14]");
        else
            System.out.print("Введенное Вами число: " + oper1 + " не попадает ни в один из промежутков [0 -14] [15 - 35] [36 - 50] [51 - 100]");


    }
}

package com.pb.shilovskiy.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        int len = array.length;
        Scanner Scan = new Scanner(System.in);
        int sum = 0;
        int ad = 0;
        int temp;
        boolean flag=true;

        for (int i = 0; i<len;i++){
            System.out.print("Введите целое число - элемент массива из " + len + " значений под номером " + (i+1) + ":  ");
            array[i] = Scan.nextInt();
        }
        System.out.print("Вы ввели массив из " + len + " значений: {");
        for (int i = 0; i<len;i++){
            sum = sum + array[i];
            if (array[i]>0){
                ad++;
            }
            System.out.print(" " + array[i]);
        }
        System.out.println(" }");
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Количество положительных элементов массива: " + ad);
        while (flag) {
            flag=false;
            for (int i = 0; i<len-1;i++){
                if (array[i]>array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    flag = true;
                }
            }
        }
        System.out.print("Отсортированный массив из " + len + " значений: {");
        for (int i = 0; i<len;i++){
            System.out.print(" " + array[i]);
        }
        System.out.println(" }");

    }


}

package com.pb.shilovskiy.hw4;

import java.util.Arrays;
import java.util.Scanner;


public class Anagram {

// Обработка строки - удаление пунктуации и пробелов и приведение к нижнему регистру
    public static String procWorkStr(String strIn){
        String resultString;
        strIn=strIn.toLowerCase();
        resultString = strIn.replaceAll("\\p{Punct}", "");
        resultString = resultString.replaceAll(" ", "");
        return resultString;
    }

//Сортировка строки
    public static String Sortstring(String strIn){
        String strOut="";
        char [] charStr = strIn.toCharArray();
        Arrays.sort(charStr);
        for (char value : charStr) {
            strOut=strOut.concat(Character.toString(value));
        }
        return strOut;
    }


    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        String str1;
        String str2;
        String str11;
        String str21;

        System.out.println("Анаграмма");
        System.out.println("Введите первую строку");
        str1 = Scan.nextLine();
        System.out.println("Введите вторую строку");
        str2 = Scan.nextLine();
// Берем символы из строки 1 и сравниваем со строкой 2
        str11=procWorkStr(str1);
        str11=Sortstring(str11);
        str21=procWorkStr(str2);
        str21=Sortstring(str21);
        if (str11.equals(str21)){
            System.out.println("Введенные Вами строки являются анаграммой");
        }
        else{
            System.out.println("Введенные Вами строки не являются анаграммой");
        }


    }
}

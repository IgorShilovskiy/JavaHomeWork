package com.pb.shilovskiy.hw4;

import java.util.Arrays;
import java.util.Scanner;


// добавить
// 1. Проверку на одну и ту же строку
// 2. удаление знаков препинания
// 3. проверку на регистр - приведение к единому регистру
// 4. проверить на перестановку слов

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

        System.out.println("The sorted array is:");
        for (char value : charStr) {
            strOut=strOut + Character.toString(value);
        }
        return strOut;
    }


//проверка на совпадение символов с учетом вхождения нескольких символов не 1 раз
    public static boolean procAnagramm(String s1, String s2) {
        boolean [] arrayf1 = new boolean [s1.length()];
        boolean [] arrayf2 = new boolean [s2.length()];
        boolean flag=true;
        char ch1;
        char ch2;
// проверяем длины слов
        if (s1.length() != s2.length()){
            return false;
        }
        else{
            for (int i=0; i<s1.length(); i++){
                for (int j=0; j<s2.length(); j++){
                    if (arrayf2[j]!=true) {
                        if (s1.charAt(i)==s2.charAt(j)){
                            arrayf1[i]=true;
                            arrayf2[j]=true;
                            break;
                        }
                    }

                }
            }
            // проверяем итоговый результат
            for (int i=0;i<s1.length();i++){
                if (arrayf1[i]==false){
                    flag=false;
                }

            }


        }
        return flag;
    }


    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        String str1;
        String str2;
        boolean flag = true;

        System.out.println("Анаграмма");
        System.out.println("Введите первую строку");
        str1 = Scan.nextLine();
        System.out.println("Введите вторую строку");
          str2 = Scan.nextLine();
// Берем символы из строки 1 и сравниваем со строкой 2
        str1=procWorkStr(str1);
        str1=Sortstring(str1);
        str2=procWorkStr(str2);
        str2=Sortstring(str2);
        if (str1.equals(str2)){
            System.out.println("Введенные Вами строки являются анаграммой");
        }
        else{
            System.out.println("Введенные Вами строки не являются анаграммой");
        }

// Теперь вариант посложнее (но он был первым подходом, глупо недоделать) - анаграмма по словам
        //        String[] strOut1 = str1.split(" ");
//        String[] strOut2 = str2.split(" ");
        // проверяем количество слов
//        if (strOut1.length != strOut2.length) {
//            System.out.println("Введенные Вами строки не являются анаграммой");
//        } else {
//            for (int i = 0; i < strOut1.length; i++) {
//                if (flag != false) {
//                    flag=procAnagramm(strOut1[i], strOut2[i]);
//                } else {
//                    break;
//                }
//
//            }
//            // проверяем итоговый результат сравления строк
//            if (flag == true) {
//                System.out.println("Введенные Вами строки являются анаграммой");
//            }
//            else{
//                System.out.println("Введенные Вами строки не являются анаграммой");
//            }
//        }



    }
}

package com.pb.shilovskiy.hw4;

import java.util.Scanner;

public class Anagram {

    public static boolean procAnagramm(String s1, String s2) {
        boolean [] arrayf1 = new boolean [s1.length()];
        boolean [] arrayf2 = new boolean [s2.length()];
        boolean flag=true;
        char ch1;
        char ch2;

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
        String[] strOut1 = str1.split(" ");
        System.out.println("Введите вторую строку");
        str2 = Scan.nextLine();
        String[] strOut2 = str2.split(" ");
        if (strOut1.length != strOut2.length) {
            System.out.println("Введенные Вами строки не являются анаграммой");
        } else {
            for (int i = 0; i < strOut1.length; i++) {
                if (flag != false) {
                    flag=procAnagramm(strOut1[i], strOut2[i]);
                } else {
                    break;
                }

            }
            if (flag == true) {
                System.out.println("Введенные Вами строки являются анаграммой");
            }
            else{
                System.out.println("Введенные Вами строки не являются анаграммой");
            }
        }

    }
}
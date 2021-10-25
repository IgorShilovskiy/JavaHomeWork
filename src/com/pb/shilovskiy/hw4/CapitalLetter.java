package com.pb.shilovskiy.hw4;

import java.util.Scanner;

public class CapitalLetter {

    static public String procUpLetter(String str){
        return str;
    }

    static String procUpperFirst(String strIn){
        char symbol;
        String substr;
        symbol=strIn.charAt(0);
        substr=strIn.substring(1);
        symbol=Character.toUpperCase(symbol);
        strIn=Character.toString(symbol);
        strIn=strIn.concat(substr);
        return strIn;
    }

    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        String strIn;

        System.out.println("Введите любое предложение или слово: ");
        strIn = Scan.nextLine();
        String[] strOut=strIn.split(" ");
        for (int i=0; i<strOut.length; i++){
            strOut[i] = procUpperFirst(strOut[i]);
            System.out.print(strOut[i]+" ");
        }
        System.out.println();
    }


}

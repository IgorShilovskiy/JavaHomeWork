package com.pb.shilovskiy.hw8;

import java.util.Scanner;

public class OnlineShop {

    public static void main(String[] args) {
        String login;
        String password;
        String confirmpassword;
        boolean regflag = false;

        Scanner Scan = new Scanner(System.in);
        System.out.println("Регистрация на сайте OnlineShop.ua");
        System.out.println("Введите логин (латинские буквы и цифры, длина 5-20 символов): ");
        login = Scan.next();
        System.out.println("Введите пароль (допустимо: латинские буквы и цифры, знак подчеркивания, длина от 5 символов): ");
        password = Scan.next();
        System.out.println("Повторите введенный пароль: ");
        confirmpassword = Scan.next();

        Auth visitor = new Auth();
        try {
            visitor.signUp(login,password,confirmpassword);
            System.out.println("Регистрация прошла успешно");
            regflag=true;
        }
        catch (WrongLoginException|WrongPasswordException e1){
            System.out.println("Регистрация не произведена. " + e1.getMessage());

        }
        if (regflag) {
            System.out.println("Авторизация на сайте OnlineShop.ua");
            System.out.println("Введите логин (латинские буквы и цифры, длина 5-20 символов): ");
            login = Scan.next();
            System.out.println("Введите пароль (допустимо: латинские буквы и цифры, знак подчеркивания, длина от 5 символов): ");
            password = Scan.next();
            try {
                visitor.signIn(login, password);
            } catch (WrongLoginException e1) {
                System.out.println("Авторизация не произведена. " + e1.getMessage());
            }
        }

    }
}

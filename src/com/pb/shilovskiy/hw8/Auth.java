package com.pb.shilovskiy.hw8;

public class Auth {
    String login;
    String password;

    public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Auth() {
        login = "login";
        password = "password";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void signUp() {

    }

    public void signIn(String login, String password) throws WrongLoginException {
        if ((this.login.equals(login))&(this.password.equals(password))) {
                System.out.println("Авторизация произведена успешно, доступ разрешен");
            } else {
                throw new WrongLoginException("Неверные логин и пароль");
            }


    }

    public void signUp(String login, String password, String confirmpassword) throws WrongLoginException, WrongPasswordException {
        if (password.equals(confirmpassword)) {
            if ((login.matches("[a-zA-Z0-9]+"))&(login.length()>=5)&(login.length()<=20)){
                if ((password.matches("[a-zA-Z0-9_]+"))&(password.length()>=5)){
                    this.login = login;
                    this.password = password;
                } else {
                    throw new WrongPasswordException("Введенный Вами пароль не соответствует требованиям");
                }
            } else {
                throw new WrongLoginException("Введенный Вами логин не соответствует требованиям");
            }

        } else {
            throw new WrongPasswordException("Введенные Вами пароли не сопадают");


        }
    }
}

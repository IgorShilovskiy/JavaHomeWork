package com.pb.shilovskiy.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class ClientChat {

    public static void main(String[] args) throws Exception {
        String serverIp = "127.0.0.1";
        int serverPort = 5555;
        Socket server = null;
        System.out.println("Соединяемся с сервером чата " + serverIp + ":" + serverPort);
        try {
            server = new Socket(serverIp, serverPort);
        }
        catch (ConnectException e){
            System.out.println("Не могу установить соединение");
            System.exit(-1);
        }
        System.out.println("Вы подключились к чату");
        System.out.println("Для выхода из чата напишите команду: \\exit");
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage, serverMessage;
        System.out.println("Введите сообщение: ");

        // Основной цикл отправки сообщений серверу
        while ((clientMessage = inConsole.readLine()) != null) {
            if ("\\exit".equalsIgnoreCase(clientMessage)) {
                System.out.println("Вы покинули чат");
                break;
            }
            outServer.println(clientMessage);
            serverMessage = inServer.readLine();
            System.out.println(serverMessage);
            System.out.println("Введите сообщение: ");
        }
        outServer.close();
        inServer.close();
        outServer.close();
        server.close();
    }
}

package com.pb.shilovskiy.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class ClientChat {

    public static class Written implements Runnable {
        BufferedReader inConsole;
        PrintWriter outServer;
        String clientMessage;

        public Written(BufferedReader inConsole, PrintWriter outServer) {
            this.inConsole = inConsole;
            this.outServer = outServer;
        }

        @Override
        public void run() {
            try {
                while ((clientMessage = inConsole.readLine()) != null) {
                    if ("\\exit".equalsIgnoreCase(clientMessage)) {
                        System.out.println("Вы покинули чат");
                        outServer.println(clientMessage);
                        break;
                    }
                    outServer.println(clientMessage);
                }
            }
            catch (Exception e){
                System.out.println("Сервер недоступен");
            }

        }
    }



    public static void main(String[] args) throws Exception {
        String serverIp = "127.0.0.1";
        int serverPort = 5555;
        Socket server = null;
        System.out.println("Соединяемся с сервером чата " + serverIp + ":" + serverPort);
        try {
            server = new Socket(serverIp, serverPort);
        } catch (ConnectException e) {
            System.out.println("Не могу установить соединение");
            System.exit(-1);
        }
        System.out.println("Вы подключились к чату");
        System.out.println("Для выхода из чата напишите команду: \\exit");
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        Written written = new Written(inConsole, outServer);
        Thread threadWritten = new Thread(written);
        threadWritten.start();

        String serverMessage;
        while (true)
            if ((serverMessage = inServer.readLine()) != null) {
                if ("\\exit".equalsIgnoreCase(serverMessage))
                    break;
                else {
                    System.out.println(serverMessage);
                }
            }

        inServer.close();
        outServer.close();
        server.close();
    }
}

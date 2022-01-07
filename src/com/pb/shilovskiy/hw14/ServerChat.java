package com.pb.shilovskiy.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerChat {

    private static ArrayList<Handler> clients;

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("Клиент " + (clients.indexOf(this)+1) + " подключился к чату");
                // поток для чтения данных
                BufferedReader in = null;
                // поток для отправки данных
                PrintWriter out = null;


                // создаем потоки для связи с клиентом
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                String clientMessage;
                String serverMessage;

                // цикл ожидания сообщений от клиента
//                System.out.println("Ожидаем сообщений");
                while ((clientMessage = in.readLine()) != null) {
                    if ("\\exit".equalsIgnoreCase(clientMessage)) {
                        break;
                    }
                    serverMessage = "Клиент " + (clients.indexOf(this)+1) + ": " + clientMessage;
                    out.println(serverMessage);
                    System.out.println(serverMessage);
                }

                System.out.println("Клиент " + (clients.indexOf(this)+1) + " покинул чат");
                clients.remove(this);
                out.close();
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Запуск сервера");
        int serverPort = 5555;
        clients = new ArrayList<Handler>();

        // серверный сокет
        ServerSocket server = null;

        // создаем серверный сокет
        try {
            server = new ServerSocket(serverPort);
            System.out.println("Сервер чата запущен на порту " + serverPort);
        } catch (IOException e) {
            System.out.println("Ошибка связи с портом 5555");
            System.exit(-1);
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            try {
                Socket clientSocket = server.accept();
                Handler client=new Handler(clientSocket);
                clients.add(client);
                threadPool.submit(client);
            } catch (IOException e) {
                System.out.println("Не могу установить соединение");
                System.exit(-1);
            }

        }

    }
}

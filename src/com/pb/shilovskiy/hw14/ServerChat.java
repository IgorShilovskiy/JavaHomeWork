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
        // поток для чтения данных
        private BufferedReader in;
        // поток для отправки данных
        private PrintWriter out;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        // отправка сообщений всем клиентам, кроме себя
        public void sendMessageToAll(String message){
            for (Handler client : clients) {
                if (!client.equals(this)){
                    client.out.println(message);
                }
            }
        }

        @Override
        public void run() {
            try {
                System.out.println(java.time.LocalDateTime.now()+ ":  " + "Клиент " + (clients.indexOf(this)+1) + " подключился к чату");

                // создаем потоки для связи с клиентом
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                sendMessageToAll(java.time.LocalDateTime.now()+ ":  " + "Клиент " + (clients.indexOf(this)+1) + " подключился к чату");
                out.println("Ваш ник: Клиент " + (clients.indexOf(this)+1));
                out.println("Введите сообщение: ");
                String clientMessage;
                String serverMessage;

                // цикл ожидания сообщений от клиента
                while ((clientMessage = in.readLine()) != null) {
                    if ("\\exit".equalsIgnoreCase(clientMessage)) {
                        out.println(clientMessage);
                        break;
                    }
                    serverMessage = java.time.LocalDateTime.now()+ ":  " + "Клиент " + (clients.indexOf(this)+1) + ": " + clientMessage;
                    sendMessageToAll(serverMessage);
                    out.println(java.time.LocalDateTime.now()+ ":  " + "доставлено");
                    System.out.println(serverMessage);
                }

                System.out.println(java.time.LocalDateTime.now()+ ":  " + "Клиент " + (clients.indexOf(this)+1) + " покинул чат");
                sendMessageToAll(java.time.LocalDateTime.now()+ ":  " + "Клиент " + (clients.indexOf(this)+1) + " покинул чат");
//                clients.remove(this);
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

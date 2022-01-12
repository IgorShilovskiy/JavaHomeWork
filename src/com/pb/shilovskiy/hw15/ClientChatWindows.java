package com.pb.shilovskiy.hw15;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class ClientChatWindows {

    private static Window window = new Window();
    
    public static class Window implements Runnable {
        private JFrame f = new JFrame ("Многопользовательский чат");
        private JTextField textMessage = new JTextField();
        private JTextArea areaMessage = new JTextArea();
        private JButton sendButton = new JButton ("Отправить");

        public void run(){
            f.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
            areaMessage.setEditable(false);
            areaMessage.setLineWrap(true);
            JScrollPane scrollPanel = new JScrollPane(areaMessage);
            f.add(scrollPanel, BorderLayout.CENTER);
            JLabel label1 = new JLabel("Окно истории чата");
            f.add(label1, BorderLayout.NORTH);
            JLabel label2 = new JLabel("Окно сообщений");
            JPanel bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.add(label2,BorderLayout.NORTH);
            bottomPanel.add(textMessage,BorderLayout.CENTER);
            bottomPanel.add(sendButton,BorderLayout.EAST);
            f.add(bottomPanel,BorderLayout.SOUTH);
            f.setBounds(600, 300, 600, 500);


            // Показать окно

            f.setVisible(true);
        }
    }

    public static class Written implements Runnable {
        PrintWriter outServer;
        String clientMessage;

        public Written(PrintWriter outServer) {
            this.outServer = outServer;
        }

        @Override
        public void run() {
            window.f.setVisible(true);
            try {
                while (window.f.isVisible()) {
                        window.sendButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (!window.textMessage.getText().trim().isEmpty()) {
                                    clientMessage = window.textMessage.getText();
                                    outServer.println(clientMessage);
                                    window.textMessage.setText("");

                                }
                            }
                        });
                }
                outServer.println("\\exit");
            }
            catch (Exception e){
                window.areaMessage.append("Сервер недоступен\n");
            }

        }
    }



    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater (window);
        String serverIp = "127.0.0.1";
        int serverPort = 5555;
        Socket server = null;
        window.areaMessage.append("Соединяемся с сервером чата " + serverIp + ":" + serverPort + "\n");
        try {
            server = new Socket(serverIp, serverPort);
        } catch (ConnectException e) {
            window.areaMessage.append("Не могу установить соединение \n");
            System.exit(-1);
        }
        window.areaMessage.append("Вы подключились к чату\n");
        BufferedReader inServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer = new PrintWriter(server.getOutputStream(), true);

        Written written = new Written(outServer);
        Thread threadWritten = new Thread(written);
        threadWritten.start();

        String serverMessage;
        window.f.setVisible(true);
        while (window.f.isVisible())
            if ((serverMessage = inServer.readLine()) != null) {
                if ("\\exit".equalsIgnoreCase(serverMessage))
                    break;
                else {
                    window.areaMessage.append(serverMessage+"\n");
                }
            }

        inServer.close();
        outServer.close();
        server.close();
    }
}


package com.pb.shilovskiy.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {

    public static void createNumbersFile (){
        Path path = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw9\\numbers.txt");
        try {
            Path testFile1 = Files.createFile(path);
            System.out.println("Файл \"" + path.toAbsolutePath() + "\" успешно создан");
        }
        catch (FileAlreadyExistsException e){
            System.out.println("Файл \"" + path.toAbsolutePath() + "\" уже существует. Будет произведена его очистка");
        }
        catch (Exception e){
            System.out.println("Файл не создан. Ошибка: " + e);
        }

        Random random = new Random();
        try {
        BufferedWriter writer = Files.newBufferedWriter(path);
            for (int i=0; i<10; i++){
                for (int j=0; j<10; j++){
                    writer.write(random.nextInt(100)+" ");
                }
                writer.newLine();
            }
        writer.close();
        System.out.println("Запись в файл произведена!");
        }

        catch (Exception e) {
            System.out.println("Ошибка записи в файл: " + e);
        }

    }

    public static void createOddNumbersFile() {

        Path path1 = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw9\\numbers.txt");
        Path path = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw9\\odd-numbers.txt");
        try {
            Path testFile1 = Files.createFile(path);
            System.out.println("Файл \"" + path.toAbsolutePath() + "\" успешно создан");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Файл \"" + path.toAbsolutePath() + "\" уже существует. Будет произведена его очистка");
        } catch (Exception e) {
            System.out.println("Файл не создан. Ошибка: " + e);
        }
        try (BufferedReader reader = Files.newBufferedReader(path1)) {
            String line;
            int value;
            BufferedWriter writer = Files.newBufferedWriter(path);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] strOut=line.split(" ");
                for (int i=0; i<strOut.length; i++){

//                    Добавить трай если не получается в инт

                            value = Integer.parseInt(strOut[i]);
                    if (value%2==0){
                        writer.write(0+" ");
                    }
                    else{
                        writer.write(strOut[i]+" ");
                    }
                }
                writer.newLine();
            }
            writer.close();
            System.out.println("Запись в файл произведена!");
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e);

        }
    }


    public static void main(String[] args) {


        createNumbersFile();
        createOddNumbersFile();

    }
}

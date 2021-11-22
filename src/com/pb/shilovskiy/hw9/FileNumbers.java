package com.pb.shilovskiy.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class FileNumbers {

    public static void createNumbersFile (){
        Path path = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw9\\numbers.txt");
        try {
            Path testFile1 = Files.createFile(path);
            LOGGER.log(Level.INFO, "Файл \"" + path.toAbsolutePath() + "\" успешно создан");
        }
        catch (FileAlreadyExistsException e){
            LOGGER.log(Level.WARNING, "Файл \"" + path.toAbsolutePath() + "\" уже существует. Будет произведена его очистка ", e);
        }
        catch (Exception e){
            LOGGER.log(Level.WARNING, "Файл не создан. Ошибка: ", e);
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
            LOGGER.log(Level.INFO, "Запись в файл произведена!");
        }

        catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка записи в файл: ", e);
        }

    }

    public static void createOddNumbersFile() {

        Path path1 = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw9\\numbers.txt");
        Path path = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw9\\odd-numbers.txt");
        try {
            Path testFile1 = Files.createFile(path);
            LOGGER.log(Level.INFO, "Файл \"" + path.toAbsolutePath() + "\" успешно создан");
        } catch (FileAlreadyExistsException e) {
            LOGGER.log(Level.WARNING, "Файл \"" + path.toAbsolutePath() + "\" уже существует. Будет произведена его очистка ", e);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Файл не создан. Ошибка: ", e);
        }
        try (BufferedReader reader = Files.newBufferedReader(path1)) {
            String line;
            int value;
            BufferedWriter writer = Files.newBufferedWriter(path);
            System.out.println("Содержимое файла \"" + path1.toAbsolutePath() + "\": ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] strOut=line.split(" ");
                for (int i=0; i<strOut.length; i++){

                    try{
                        value = Integer.parseInt(strOut[i]);}
                    catch (Exception e1){
                        LOGGER.log(Level.WARNING, "Символ " + strOut[i] + " заменен на 0");
                        value=0;}
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
            LOGGER.log(Level.INFO, "Запись в файл произведена!");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка чтения файла: ", e);

        }
    }


    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());

        createNumbersFile();
        createOddNumbersFile();

    }
}

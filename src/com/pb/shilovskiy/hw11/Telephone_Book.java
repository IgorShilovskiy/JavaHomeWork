package com.pb.shilovskiy.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pb.shilovskiy.hw9.FileNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Telephone_Book {

    static class PersonNameComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {
            return a.getName().compareTo(b.getName());
        }
    }

    static class PersonDateBirthdayComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {
            return a.getDate_birthday().compareTo(b.getDate_birthday());
        }
    }

    public static void create_Telephone_Book(ArrayList<Person> persons){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<String> numbers1 = new ArrayList<>();
        numbers1 = Arrays.asList("+380671606697", "+380503454654");
        Person person1 = new Person("Абрамов Игорь Давыдович", LocalDate.parse("01.04.1974", formatter),numbers1,"г.Днепр, пр.Гагарина, 92, кв.47", LocalDateTime.now());
        persons.add(person1);
        List<String> numbers2 = new ArrayList<>();
        numbers2 = Arrays.asList("+380974758001");
        Person person2 = new Person("Иванов Владимир Петрович", LocalDate.parse("15.03.1976", formatter),numbers2,"г.Днепр, пр.Слобожанский, 3, кв.20", LocalDateTime.now());
        persons.add(person2);
        List<String> numbers3 = new ArrayList<>();
        numbers3 = Arrays.asList("+380978997001", "+380504758098", "+380935117895");
        Person person3 = new Person("Бондаренко Юрий Валентинович", LocalDate.parse("13.12.1981", formatter),numbers3,"г.Днепр, ул.Станичная, 21", LocalDateTime.now());
        persons.add(person3);
    }


    public static void add_Person (ArrayList<Person> persons) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Person person1 = new Person();
        List<String> numbers1 = new ArrayList<>();
        Scanner Scan = new Scanner(System.in);
        System.out.println("Введите ФИО: ");
        person1.setName(Scan.nextLine());
        String command = "y";
        String number;
        do {
                System.out.println("Введите номер телефона: ");
                number = Scan.nextLine();
                numbers1.add(number);
                System.out.println("Добавить еще один номер? Введите y или n");
                command = Scan.nextLine();
            if (command.equals("n")) {
                break;
            }
            while ((!command.equals("y"))&(!command.equals("n"))) {
                System.out.println("Программа не понимает такой комманды");
                System.out.println("Введите y или n");
                command = Scan.nextLine();
            }
        }
        while (command.equals("y"));
        person1.setNumbers(numbers1);
        System.out.println("Введите дату рождения в формате дд.ММ.гггг: ");
        number = Scan.nextLine();
        try {
            person1.setDate_birthday(LocalDate.parse(number, formatter));
        }
        catch (DateTimeParseException e) {
            System.out.println("Введена неверная дата. Запись не добавлена");
            return;
        }
        System.out.println("Введите адрес проживания: ");
        number = Scan.nextLine();
        person1.setAdress(number);
        person1.setDate_modify(LocalDateTime.now());
        persons.add(person1);
        System.out.println("Запись добавлена в телефонную книгу: " + person1);
        }



    public static void search_Person(ArrayList<Person> persons){
        int operation;
        int index;
        int index_Person=-1;
        String search;
        Scanner Scan = new Scanner(System.in);
            System.out.println("1. Поиск по ФИО");
            System.out.println("2. Поиск по номеру телефона");
            System.out.println("3. Поиск по адресу");
            System.out.println("0. Выход из поиска");
            System.out.print("Выберите один из пунктов меню: ");
            operation = Scan.nextInt();
            switch (operation){
                case 1:
                    System.out.println("Введите ФИО: ");
                    search=Scan.nextLine();
                    search=Scan.nextLine();
                    for (int i=0; i<persons.size(); i++){
                        index=persons.get(i).getName().indexOf(search);
                        if (index > -1) {
                            index_Person=i;
                            System.out.println("Результат поиска: ");
                            System.out.println(persons.get(index_Person));
                            System.out.println("Номер записи: " + (index_Person+1));
                        }

                }
                    break;
                case 2:
                    System.out.println("Введите номер телефона: ");
                    search=Scan.nextLine();
                    search=Scan.nextLine();
                    for (int i=0; i<persons.size(); i++) {
                        for (int j = 0; j < persons.get(i).getNumbers().size(); j++) {
                            index = persons.get(i).getNumbers().get(j).indexOf(search);
                            if (index > -1) {
                                index_Person=i;
                                System.out.println("Результат поиска: ");
                                System.out.println(persons.get(index_Person));
                                System.out.println("Номер записи: " + (index_Person+1));
                            }
                        }
                        }
                    break;
                case 3:
                    System.out.println("Введите адрес: ");
                    search=Scan.nextLine();
                    search=Scan.nextLine();
                    for (int i=0; i<persons.size(); i++){
                        index=persons.get(i).getAdress().indexOf(search);
                        if (index>-1){
                            index_Person=i;
                            System.out.println("Результат поиска: ");
                            System.out.println(persons.get(index_Person));
                            System.out.println("Номер записи: " + (index_Person+1));
                        }
                    }
                    break;
                case 0:
                    break;
        }
        if (operation!=0) {
            if (index_Person == -1) {
                System.out.println("По указанным параметрам запись не найдена");
            }
        }
    }


    public static void del_Person(ArrayList<Person> persons){
        Scanner Scan = new Scanner(System.in);
        int index;
        System.out.println("Введите номер записи, которую нужно удалить");
        index = Scan.nextInt();
        index--;
        if ((index>-1)&(index<persons.size())) {
            System.out.println("Запись удалена из телефонной книги: " + persons.get(index));
            persons.remove(index);
        }
        else {
            System.out.println("Записи с таким номером не найдено");
        }
    }


    public static void modify_Person (ArrayList<Person> persons) throws DateTimeParseException{
        Scanner Scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        Person person = new Person();
        int index;
        int operation;
        String str;
        System.out.println("Введите номер записи, которую нужно отредактировать");
        index = Scan.nextInt();
        index--;
        if ((index>-1)&(index<persons.size())) {
            Person person = new Person(persons.get(index));
            ArrayList<String>numbers = new ArrayList<String>(persons.get(index).getNumbers());
            do {
                System.out.println("Запись для редактирования: " + person);
                System.out.println("1. Отредактировать ФИО");
                System.out.println("2. Добавить номер телефона");
                System.out.println("3. Удалить номер телефона");
                System.out.println("4. Отредактировать дату рождения");
                System.out.println("5. Отредактировать адрес");
                System.out.println("9. Сохранить изменения");
                System.out.println("0. Выход без сохранения");
                System.out.print("Выберите один из пунктов меню: ");
                operation = Scan.nextInt();
                switch (operation) {
                    case 1:
                        System.out.println("Введите новое ФИО: ");
                        str = Scan.nextLine();
                        str = Scan.nextLine();
                        person.setName(str);
                        break;
                    case 2:
                        System.out.println("Введите новый номер телефона: ");
                        str = Scan.nextLine();
                        str = Scan.nextLine();
                        numbers.add(str);
                        person.setNumbers(numbers);
                        break;
                    case 3:
                        System.out.println("Введите номер записи номера телефона для удаления: ");
                        int index1 = Scan.nextInt();
                        index1--;
                        if ((index1>-1)&(index1<numbers.size())){
                            numbers.remove(index1);
                            person.setNumbers(numbers);
                        }
                        else {
                            System.out.println("Записи с таким номером не найдено");
                        }
                        break;
                    case 4:
                        System.out.println("Введите новую дату рождения: ");
                        str = Scan.next();
                        try {
                            person.setDate_birthday(LocalDate.parse(str, formatter));
                        }
                        catch (DateTimeParseException e) {
                            System.out.println("Введена неверная дата. Дата не будет отредактирована");
                        }
                        break;
                    case 5:
                        System.out.println("Введите новый адрес: ");
                        str = Scan.nextLine();
                        str = Scan.nextLine();
                        person.setAdress(str);
                        break;
                    case 9:
                        System.out.println("Произведено редактирование записи: ");
                        System.out.println(persons.get(index));
                        System.out.println("Отредактированая запись: ");
                        System.out.println(person);
                        person.setDate_modify(LocalDateTime.now());
                        persons.set(index, person);
                        break;
                    case 0:
                        break;
                }
            }
            while ((operation!=0)&(operation!=9));
            if (operation==9) {
                System.out.println("Запись отредактирована: " + persons.get(index));
            }
            else if (operation==0) {
                System.out.println("Запись не отредактирована: " + persons.get(index));
            }
        }
        else {
            System.out.println("Записи с таким номером не найдено");
        }
    }

    public static void print_Person (ArrayList<Person> persons){
        PersonNameComparator pNameComp = new PersonNameComparator();
        PersonDateBirthdayComparator pDBComp = new PersonDateBirthdayComparator();
        int operation;
        Scanner Scan = new Scanner(System.in);
        System.out.println("1. Сортировка по ФИО");
        System.out.println("2. Сортировка по дате рождения");
        System.out.println("0. Отмена печати");
        System.out.print("Выберите один из пунктов меню: ");
        operation = Scan.nextInt();
        switch (operation){
            case 1:
                Collections.sort(persons, pNameComp);
                System.out.println(persons);
                break;
            case 2:
                Collections.sort(persons, pDBComp);
                System.out.println(persons);
                break;
            case 0:
                break;
        }
    }


    public static void printToFile_Person(ArrayList<Person> persons) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        mapper.registerModule(module);

        SimpleModule module1 = new SimpleModule();
        module1.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        mapper.registerModule(module1);

        String json = mapper.writeValueAsString(persons);


        Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());
        Path path = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw11\\TelephoneBook.txt");
        try {
            Path testFile1 = Files.createFile(path);
            LOGGER.log(Level.INFO, "Файл \"" + path.toAbsolutePath() + "\" успешно создан");
        } catch (FileAlreadyExistsException e) {
            LOGGER.log(Level.WARNING, "Файл \"" + path.toAbsolutePath() + "\" уже существует. Будет произведена его очистка ");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Файл не создан. Ошибка: ");
        }


        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write(json);
            writer.close();
        }
        catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка чтения файла: ");
        }

    }

    public static ArrayList<Person> readFromFile_Person() throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        SimpleModule module1 = new SimpleModule();
        module1.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module1);


        Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());
        Path path = Paths.get("out\\production\\JawaHomeWork\\com\\pb\\shilovskiy\\hw11\\TelephoneBook.txt");
        String json="";
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null){
                json = json.concat(line);
            }
            reader.close();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Ошибка чтения файла: ");
        }
        LOGGER.log(Level.INFO, "Файл прочитан");
      //  System.out.println(json);
     return mapper.readValue(json, new TypeReference<ArrayList<Person>>() {});
 //       System.out.println(persons);
    }


    public static void main(String[] args) throws Exception {
        int operation;
        Scanner Scan = new Scanner(System.in);
        System.out.println("Вы запустили приложение \"Телефонная книга\"");
        ArrayList<Person> persons = new ArrayList<Person>();
        do {
            System.out.println("1. Создание телефонной книги");
            System.out.println("2. Добавление записи");
            System.out.println("3. Поиск записи");
            System.out.println("4. Удаление записи");
            System.out.println("5. Редактирование записи");
            System.out.println("6. Печать записей");
            System.out.println("7. Записать в файл");
            System.out.println("8. Прочитать из файла");
            System.out.println("0. Выход из программы");
            System.out.print("Выберите один из пунктов меню: ");
            operation = Scan.nextInt();



            switch (operation){
                case 1:
                    create_Telephone_Book(persons);
                    System.out.println("Создание телефонной книги");
                    break;
                case 2:
                    System.out.println("Добавление записи");
                    add_Person(persons);
                    break;
                case 3:
                    System.out.println("Поиск записи");
                    search_Person(persons);
                    break;
                case 4:
                    System.out.println("Удаление записи");
                    del_Person(persons);
                    break;
                case 5:
                    System.out.println("Редактирование записи");
                        modify_Person(persons);
                    break;
                case 6:
                    System.out.println("Печать телефонной книги");
                    print_Person(persons);
                    break;
                case 7:
                    System.out.println("Запись в файл");
                    printToFile_Person(persons);
                    break;
                case 8:
                    System.out.println("Чтение из файла");
                    persons = readFromFile_Person();
                    break;
                case 0:
                    System.out.println("Приложение \"Телефонная книга\" завершило работу");
                    break;
            }
        }
        while (operation!=0);

    }
}

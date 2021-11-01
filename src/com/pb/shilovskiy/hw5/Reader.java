package com.pb.shilovskiy.hw5;

public class Reader {
    private String name;
    private int number;
    private String faculty;
    private String date;
    private String phone;


    public Reader(){
        this.name = "unknown name";
        this.number = 0;
        this.faculty = "unknown name";
        this.date = "**.**.****";
        this.phone = "unknown phone";
    }

    public Reader(String name, int number, String faculty, String date, String phone){
        this.name = name;
        this.number = number;
        this.faculty = faculty;
        this.date = date;
        this.phone = phone;
    }

    /**
     * Выводит сообщение сколько читатель взял книг в библиотеке
     * @param countBooks - количество книг
     */
    public void takeBook(int countBooks){
        System.out.println(name + " взял в библиотеке " + countBooks + " книги");
    }

    /**
     * Выводит информацию какие книги (только названия) взял читатель
     * @param namesBooks - названия книг
     */
    public void takeBook(String... namesBooks){
        System.out.println(name + " взял в библиотеке следующие книги:");
        for (String namesBook : namesBooks){
            System.out.print(namesBook + ", ");
        }
        System.out.println("\b" + "\b" + ".");
    }

    /**
     * Выводит информацию какие книги (полное наименование) взял читатель
     * @param books- объекты класса Books
     */
    public void takeBook(Book... books){
        System.out.println(name + " взял в библиотеке следующие книги:");
        for (Book book : books){
            System.out.println(book.getName() + " (" + book.getAuthor() + ", " + book.getYear() + "г.)");
        }
    }
    /**
     * Выводит информацию какие книги (полное наименование) вернул читатель
     * @param books- объекты класса Books
     */
    public void returnBook(Book... books){
        System.out.println(name + " вернул в библиотеку следующие книги:");
        for (Book book : books){
            System.out.println(book.getName() + " (" + book.getAuthor() + ", " + book.getYear() + "г.)");
        }
    }


    /**
     * Выводит сообщение сколько читатель вернул книг в библиотеку
     * @param countBooks - количество книг
     */
    public void returnBook(int countBooks){
        System.out.println(name + " вернул в библиотеку " + countBooks + " книги");
    }

    /**
     * Выводит информацию какие книги (только названия) вернул читатель
     * @param namesBooks - названия книг
     */
    public void returnBook(String... namesBooks){
        System.out.println(name + " вернул в библиотеку следующие книги:");
        for (String namesBook : namesBooks){
            System.out.print(namesBook + ", ");
        }
        System.out.println("\b" + "\b" + ".");
    }

    public void printReader(){
        System.out.println(name + " (номер читательского: " + number + ", факультет: " + faculty + ", дата рождения: " + date + ", номер телефона: " + phone + ")");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getPhone() {
        return phone;
    }
}

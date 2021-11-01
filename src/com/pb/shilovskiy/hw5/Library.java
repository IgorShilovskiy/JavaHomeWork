package com.pb.shilovskiy.hw5;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Приключения","Иванов И.И.",2000);
        Book book2 = new Book("Словарь","Сидоров А.В.",1980);
        Book book3 = new Book("Энциклопедия","Гусев К.В.",2010);
        Book book4 = new Book("Химия","Семенов В.В.",2008);
        Book book5 = new Book("Астрономия","Коперник А.С.",1976);
        Book book6 = new Book("Основы термодинамики","Панфилов М.А.",2018);

        Reader reader1 = new Reader("Шиловский И.В.",1,"Прикладной математики","16.12.1980","+380671606697");
        Reader reader2 = new Reader("Терентьев А.С.",2,"Экономической кибернетики","28.05.1980","+380631851209");
        Reader reader3 = new Reader("Сергеева М.В.",3,"Механико-математический","27.01.1978","+380994758001");
        Reader reader4 = new Reader("Петровский С.И.",4,"Радио-физический","11.12.1984","+380679007001");
        Reader reader5 = new Reader("Ткаленко Ю.С.",5,"Биологии","02.06.1983","+380931125896");
        Reader reader6 = new Reader("Кирюхин С.А.",6,"Физической культуры","08.03.1976","+380995650825");

        Book[] arrayBooks = new Book[] {book1, book2, book3, book4, book5, book6};

        Reader[] arrayReaders = new Reader[] {reader1, reader2, reader3, reader4, reader5, reader6};

        System.out.println("В библиотеке в наличии следующие книги:");
        for (int i=0; i<arrayBooks.length; i++){
            arrayBooks[i].printBook();
        }
        System.out.println();

        System.out.println("В библиотеке зарегистрированы следующие читатели:");
        for (int i=0; i<arrayReaders.length; i++) {
            arrayReaders[i].printReader();
        }
        System.out.println();

        reader1.takeBook(3);
        reader2.takeBook(book1.getName(), book2.getName(), book3.getName());
        reader3.takeBook(book4, book5, book6);
        System.out.println();

        reader4.returnBook(3);
        reader5.returnBook(book4.getName(), book5.getName(), book6.getName());
        reader6.returnBook(book1, book2, book3, book4);


    }
}

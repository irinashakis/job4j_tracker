package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book textbook = new Book("Textbook", 456);
        Book notebook = new Book("Notebook", 34);
        Book cleanCode = new Book("Clean code", 45);
        Book stories = new Book("Stories", 78);
        Book[] books = new Book[4];
        books[0] = textbook;
        books[1] = notebook;
        books[2] = cleanCode;
        books[3] = stories;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        System.out.println("Replace:");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        for (Book bk : books) {
            if (bk.getName().equals("Clean code")) {
                System.out.println("Book found: " + bk.getName() + " - " + bk.getCount());
            }
        }
    }
}

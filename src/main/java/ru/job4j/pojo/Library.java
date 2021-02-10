package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book aBook1 = new Book("Java. Полное руководство", 1500);
        Book aBook2 = new Book("Неразборчиво", 460);
        Book aBook3 = new Book("Java. Библиотека профессионала, том 1", 866);
        Book aBook4 = new Book("Clean Agile. Back to Basics", 352);
        Book[] books = new Book[4];
        books[0] = aBook1;
        books[1] = aBook2;
        books[2] = aBook3;
        books[3] = aBook4;
        books[1].setName("Clean Code");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Название: \"" + books[i].getName() + '\"'
                    + ", страниц: " + books[i].getNumOfPages());
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book tempBook : books) {
            System.out.println("Название: \"" + tempBook.getName() + '\"'
                    + ", страниц: " + tempBook.getNumOfPages());
        }
        System.out.println();
        for (Book tempBook : books) {
            if (tempBook.getName().equals("Clean Code")) {
                System.out.println("Название: \"" + tempBook.getName() + '\"'
                        + ", страниц: " + tempBook.getNumOfPages());
            }
        }
    }
}

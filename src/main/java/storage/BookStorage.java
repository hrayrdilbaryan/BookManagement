package storage;

import model.Books;

public class BookStorage {


    private Books[] array = new Books[10];

    private int size = 0;

    public void add(Books value) {
        if (size == array.length) {
            Books[] tmp = new Books[array.length + 10];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            array = tmp;
        }
        array[size++] = value;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);

        }
    }


    public void printBookByAuthor(String author) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getAuthor().equals(author)) {
                System.out.println(array[i]);
                count++;
            }

        }
        if (count == 0) {
            System.out.println("no book author");
        }
    }

    public void printBookByGenre(String genre) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getGenre().equals(genre)) {
                System.out.println(array[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("no book genre");
        }

    }

    public void printByPriceReng(double price, double price1) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getPrice() < price1 && array[i].getPrice() > price) {
                System.out.println(array[i]);
                count++;
            }

        }
        if (count == 0) {
            System.out.println("no price in rang");
        }


    }
}

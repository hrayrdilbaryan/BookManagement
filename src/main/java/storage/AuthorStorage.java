package storage;

import model.Author;

public class AuthorStorage {

    private Author[] array = new Author[10];
    private int size = 0;

    public void add(Author author){
        if (size == array.length){
            increaseArray();
        }
        array[size++] = author;
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaseArray() {
        Author[] temp = new Author[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void printAuthorByIndex(int authorIndex) throws AuthorNotFoundException{
        int authorCount = 0;
        for (int i = authorIndex; i < size; i++) {
            if (authorIndex == i){
                authorCount ++;
            }
        }
        if (authorCount == 0){
            throw new AuthorNotFoundException();
        }
    }



}

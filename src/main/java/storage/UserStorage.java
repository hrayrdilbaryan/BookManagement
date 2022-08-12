package storage;

import model.Registration;

public class UserStorage {

    private Registration[] array = new Registration[10];

    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void loginUser(String login, String password) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getLogin().equals(login) && array[i].getPassword().equals(password)) {
                System.out.println("welcome " + array[i].getName());
                count++;
            }

        }
        if (count == 0){
            System.out.println("invalid login or password");
        }
    }

    public void regUs(Registration val) {
        if (size == array.length) {
            Registration[] tmp = new Registration[array.length + 10];
            for (int i = 0; i < size; i++) {
                tmp[i] = array[i];
            }
            array = tmp;
        }
        array[size++] = val;
    }


}

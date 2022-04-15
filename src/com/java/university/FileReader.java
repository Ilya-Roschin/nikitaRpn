package com.java.university;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader {

    private static final String PATH = "src/com/java/university/data.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() throws FileException {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            throw new FileException();
        }
    }

    public List<User> findAll() throws FileException {
        FileInputStream fileInputStream = null;
        List<User> userList = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Users users = (Users) objectInputStream.readObject();
                userList = users.getUsers();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new FileException();
        }
        return userList;
    }

    public void addToFile(User user) throws FileException {
        FileOutputStream outputStream = null;
        List<User> usersList = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            usersList.add(user);
            objectOutputStream.writeObject(new Users(usersList));

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) throws FileException {
        List<User> userList = findAll();
        clearFile();
        for (int i = 0; i < userList.size(); i++) {
            if (Objects.equals(userList.get(i), user)) {
                userList.remove(user);
                break;
            }
        }

        for (User element: userList) {
            addToFile(element);
        }
    }
}

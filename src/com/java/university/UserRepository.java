package com.java.university;

import java.util.List;
import java.util.Objects;

public class UserRepository {

    private static final FileReader FILE_READER = new FileReader();

    public void addUser(User user) throws CustomException, FileException {
        if (findByName(user.getUsername()).getUsername().equals("empty")) {
            FILE_READER.addToFile(user);
        } else {
            System.out.println("This user already exists ");
        }
    }

    public List<User> findAll() throws FileException {
        return FILE_READER.findAll();
    }

    public User findByName(String username) throws CustomException, FileException {
        for (User element : FILE_READER.findAll()) {
            if (Objects.equals(element.getUsername(), username)) {
                return element;
            }
        }
        throw new CustomException();
    }

    public void updateUser(String username, User updatedUser) throws CustomException, FileException {
        if (!findByName(username).equals("empty")) {
            FILE_READER.deleteUser(findByName(username));
            FILE_READER.addToFile(updatedUser);
        } else {
            System.out.println("User not founded");
        }
    }


}

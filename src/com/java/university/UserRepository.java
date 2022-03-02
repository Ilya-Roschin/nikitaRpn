package com.java.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if (findByName(user.getUsername()).getUsername().equals("empty")) {
            users.add(user);
        } else {
            System.out.println("This user already exists ");
        }
    }

    public List<User> findAll() {
        return users;
    }

    public User findByName(String username) {
        for (User element : users) {
            if (Objects.equals(element.getUsername(), username)) {
                return element;
            }
        }
        //если user не найден
        //используется измененный пустой конструктор, который вернет user с одним полем username = "empty"
        //обработа такого user идет в местах вызова этого метода
        return new User();
    }

    public void updateUser(String username, User updatedUser) {
        if (!findByName(username).equals("empty")) {
            User userFromRepository = findByName(username);
            userFromRepository.setUsername(updatedUser.getUsername());
            userFromRepository.setRole(updatedUser.isRole());
            userFromRepository.setCheck(updatedUser.getCheck());
        } else {
            System.out.println("User not founded");
        }
    }


}

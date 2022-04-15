package com.java.university;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Users implements Serializable {

    private List<User> users = new ArrayList<>();

    public Users(List<User> users) {
        this.users = users;
    }

    public Users() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

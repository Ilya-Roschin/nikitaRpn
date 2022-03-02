package com.java.university;

import java.util.Objects;

public class User {

    private String username;

    private Check check;

    private boolean role;


    public User(String username, Check check, boolean role) {
        this.username = username;
        this.check = check;
        this.role = role;
    }

    public User() {
        this.username = "empty";
    }

    public String getUsername() {
        return username;
    }

    public Check getCheck() {
        return check;
    }

    public boolean isRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(check, user.check);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, check);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", check=" + check +
                '}';
    }
}

package com.java.university;

import java.util.Objects;
import java.util.Scanner;

public class UserService {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserRepository USER_REPOSITORY = new UserRepository();

    public void findCheck() {
        User foundedUser = USER_REPOSITORY.findByName(inputUsername());
        if (!foundedUser.getUsername().equals("empty") && !foundedUser.isRole()) {
            Check check = foundedUser.getCheck();

            if (check.isStatus()) {
                System.out.println("User: " + foundedUser.getUsername() + "\n" +
                        "Card: " + check.getCardNumber() + "\n" +
                        "Money: " + check.getMoney() + "\n" + "------------");
            } else {
                System.out.println("User: " + foundedUser.getUsername() + "\n" + "Card blocked!!!" + "\n" + "------------");
            }

        } else {
            System.out.println("User not founded" + "\n" + "------------");
        }

    }

    public void transaction() {
        System.out.println("from user: ");
        User userFrom = USER_REPOSITORY.findByName(inputUsername());
        System.out.println("To user: ");
        User userTo = USER_REPOSITORY.findByName(inputUsername());

        if (!Objects.equals(userFrom.getUsername(), "empty") &&
                !Objects.equals(userTo.getUsername(), "empty") &&
                !userTo.isRole() && !userFrom.isRole() &&
                userTo.getCheck().isStatus() && userFrom.getCheck().isStatus()) {

            System.out.println("enter transfer amount ");
            long transferAmount = SCANNER.nextLong();

            userTo.setCheck(new Check(userTo.getCheck().getCardNumber(),
                    userTo.getCheck().getMoney() + transferAmount,
                    userTo.getCheck().isStatus()));

            userFrom.setCheck(new Check(userFrom.getCheck().getCardNumber(),
                    userFrom.getCheck().getMoney() - transferAmount,
                    userFrom.getCheck().isStatus()));
        } else {
            System.out.println("Incorrect input or one of this user is blocked");
        }

    }

    public void blockCheck() {
        User foundedUser = USER_REPOSITORY.findByName(inputUsername());
        if (!Objects.equals(foundedUser.getUsername(), "empty")) {
            Check check = foundedUser.getCheck();
            check.setStatus(!check.isStatus());
        } else {
            System.out.println("Operation is not successful");
        }

    }

    public void findAllCheckStatus() {
        for (User user : USER_REPOSITORY.findAll()) {
            if (!user.isRole()) {
                System.out.println("User: " + user.getUsername());
                if (user.getCheck().isStatus()) {
                    System.out.println("Card: " + user.getCheck().getCardNumber() + "\n" +
                            "Money: " + user.getCheck().getMoney() + "\n" + "------------");
                } else {
                    System.out.println("Blocked" + "\n" + "------------");
                }
            }
        }
    }

    private String inputUsername() {
        System.out.println("Enter username");
        return SCANNER.nextLine();
    }
}

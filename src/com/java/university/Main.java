package com.java.university;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserService USER_SERVICE = new UserService();

    public static void main(String[] args) {
        Init init = new Init();
        init.init();
        readMainMenu();
        mainController();
    }

    public static void readMainMenu() {
        System.out.println("Menu \n" +
                "1. User \n" +
                "2. Admin\n" +
                "3. back");
    }

    private static void mainController() {
        switch (choose()) {
            case 1:
                readUserMenu();
                userController();
                break;
            case 2:
                readAdminMenu();
                adminController();
                break;
            default:
                System.out.println("Incorrect input!!!");
        }
        readMainMenu();
        mainController();
    }

    public static void readUserMenu() {
        System.out.println("User Menu \n" +
                "1. проверить счет \n" +
                "2. задонатить на другую карту\n" +
                "3. back");
    }

    public static void userController() {
        switch (choose()) {
            case 1:
                USER_SERVICE.findCheck();
                break;
            case 2:
                USER_SERVICE.transaction();
                break;
            default:
                System.out.println("Выход...");
        }
        readMainMenu();
        mainController();
    }

    public static void readAdminMenu() {
        System.out.println("User Menu \n" +
                "1. check cards\n" +
                "2. refactor check status\n" +
                "3. back");
    }

    public static void adminController() {
        switch (choose()) {
            case 1:
                USER_SERVICE.findAllCheckStatus();
                break;
            case 2:
                USER_SERVICE.blockCheck();
                break;
            default:
                System.out.println("Выход...");
        }
        readMainMenu();
        mainController();
    }

    private static int choose() {
        return SCANNER.nextInt();
    }
}

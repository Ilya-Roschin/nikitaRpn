package com.java.university;

public class Init {

    private static final UserRepository USER_REPOSITORY = new UserRepository();

    public void init() throws CustomException, FileException {

        USER_REPOSITORY.addUser(new User("VovaVist", new Check("3324", 0l, true), false));
        USER_REPOSITORY.addUser(new User("IvanDarkholmovich", new Check("5434", 300l, true), false));
        USER_REPOSITORY.addUser(new User("Admin", new Check(), true));

    }
}

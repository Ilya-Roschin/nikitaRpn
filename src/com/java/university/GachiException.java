package com.java.university;

public class GachiException extends Exception{


    public GachiException() {
    }

    public GachiException(String message) {
        super(message);
    }

    public GachiException(String message, Throwable cause) {
        super(message, cause);
    }

    public GachiException(Throwable cause) {
        super(cause);
    }
}

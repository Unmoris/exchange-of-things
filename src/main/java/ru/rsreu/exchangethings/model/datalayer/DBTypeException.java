package ru.rsreu.exchangethings.model.datalayer;

public class DBTypeException extends RuntimeException {
    public DBTypeException() {
        super();
    }

    public DBTypeException(String message) {
        super(message);
    }
}


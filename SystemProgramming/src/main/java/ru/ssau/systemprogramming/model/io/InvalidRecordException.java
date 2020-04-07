package ru.ssau.systemprogramming.model.io;

public class InvalidRecordException extends Exception {

    String message;

    public InvalidRecordException(String message){
        super(message);
        this.message = message;
    }

}

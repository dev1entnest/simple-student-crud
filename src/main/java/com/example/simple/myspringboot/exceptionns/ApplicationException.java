package com.example.simple.myspringboot.exceptionns;

public class ApplicationException extends RuntimeException {
    private String message;
    public ApplicationException(String message){
        super(message);
    }
}

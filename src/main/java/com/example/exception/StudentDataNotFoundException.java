package com.example.exception;

public class StudentDataNotFoundException extends RuntimeException{

    private String message;

    public StudentDataNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

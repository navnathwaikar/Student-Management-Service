package com.example.exception;

public class ServiceNotFound extends RuntimeException{

    private String message;

    public ServiceNotFound(String message) {
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

package com.example.pizzeramorebackend.exceptions;

public class PasswordNotCorrectException extends RuntimeException {
    public PasswordNotCorrectException() {
        super("Password is not correct");
    }
}

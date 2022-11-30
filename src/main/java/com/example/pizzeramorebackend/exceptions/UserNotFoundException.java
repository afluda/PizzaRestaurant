package com.example.pizzeramorebackend.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("Could not find user with email: " + email);
    }

    public UserNotFoundException() {
        super("Could not find user");
    }
}

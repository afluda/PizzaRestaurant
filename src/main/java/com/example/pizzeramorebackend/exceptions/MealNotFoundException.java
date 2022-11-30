package com.example.pizzeramorebackend.exceptions;

public class MealNotFoundException extends RuntimeException {
    public MealNotFoundException(String id) {
        super("Could not find meal with id" + id);
    }

}

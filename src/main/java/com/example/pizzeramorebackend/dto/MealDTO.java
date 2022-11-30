package com.example.pizzeramorebackend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MealDTO {
    private String id;
    private String name;
    private double price;
    private List<String> ingredients;
    private String pizzaImage;
}

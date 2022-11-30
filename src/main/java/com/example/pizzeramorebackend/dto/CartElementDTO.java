package com.example.pizzeramorebackend.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartElementDTO {
    @NotEmpty
    private CartDTO cart;
    @NotEmpty
    private MealDTO meal;
    @NotEmpty
    private int quantity;
}

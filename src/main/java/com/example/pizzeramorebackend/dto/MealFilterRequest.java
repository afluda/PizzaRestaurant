package com.example.pizzeramorebackend.dto;

import lombok.*;

import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MealFilterRequest {

    @Min(0)
    private int minPrice;
    @Min(0)
    private int maxPrice;
    private List<String> preferredIngredients = new ArrayList<>();
    private List<String> excludedIngredients = new ArrayList<>();


    public void validate() {
        if (maxPrice < minPrice) throw new ValidationException("Maximum price cannot be less than minimum price");
    }

}

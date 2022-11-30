package com.example.pizzeramorebackend.services;


import com.example.pizzeramorebackend.exceptions.MealNotFoundException;
import com.example.pizzeramorebackend.models.Meal;
import com.example.pizzeramorebackend.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    public List<Meal> getFilteredMeals(int minPrice, int maxPrice, List<String> preferredIngredients, List<String> excludedIngredients) {
        return mealRepository.findAll()
                .stream()
                .filter(meal -> meal.getPrice() >= minPrice && meal.getPrice() <= maxPrice)
                .filter(meal -> !meal.getIngredients().contains(excludedIngredients)).filter(meal -> {
                    for (int i = 0; i < preferredIngredients.size(); i++) {
                        if (meal.getIngredients().contains(preferredIngredients.get(i))) {
                            return true;
                        }
                    }
                    return false;
                }).toList();
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public void deleteMealById(String id) {
        mealRepository.deleteById(id);
    }

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public void updateMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public Meal getMealById(String id) {
        return (mealRepository.findById(id).orElseThrow(() -> new MealNotFoundException(id)));
    }


}

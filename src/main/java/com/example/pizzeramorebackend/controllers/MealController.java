package com.example.pizzeramorebackend.controllers;

import com.example.pizzeramorebackend.dto.MealDTO;
import com.example.pizzeramorebackend.dto.MealFilterRequest;
import com.example.pizzeramorebackend.mapper.MealMapper;
import com.example.pizzeramorebackend.services.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;
    private final MealMapper mealMapper;

    @GetMapping("/filtered")
    public ResponseEntity<List<MealDTO>> filterMeals(@Valid @RequestBody MealFilterRequest mealFilterRequest) {
        List<MealDTO> allMeals = mealService
                .getFilteredMeals(mealFilterRequest.getMinPrice(), mealFilterRequest.getMaxPrice(), mealFilterRequest.getPreferredIngredients(), mealFilterRequest.getExcludedIngredients())
                .stream()
                .map(mealMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(allMeals);
    }

    @GetMapping
    public ResponseEntity<List<MealDTO>> getMeals() {
        List<MealDTO> allMeals = mealService.getAllMeals()
                .stream()
                .map(mealMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(allMeals);
    }

    @PostMapping
    public ResponseEntity<MealDTO> createMeal(@Valid @RequestBody MealDTO meal) {
        MealDTO createdMeal = mealMapper.toDTO(mealService.saveMeal(mealMapper.fromDTO(meal)));
        return ResponseEntity.status(201).body(createdMeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MealDTO> deleteMeal(@PathVariable String id) {
        mealService.deleteMealById(id);
        return ResponseEntity.ok(mealMapper.toDTO(mealService.getMealById(id)));
    }

    @PutMapping
    public ResponseEntity<MealDTO> updateMeal(@Valid @RequestBody MealDTO meal) {
        mealService.updateMeal(mealMapper.fromDTO(meal));
        return ResponseEntity.ok(meal);
    }


}

package com.example.pizzeramorebackend;

import com.example.pizzeramorebackend.models.Meal;
import com.example.pizzeramorebackend.repository.MealRepository;
import com.example.pizzeramorebackend.services.MealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MealServiceTests {
    @Mock
    private MealRepository mealRepository;
    @InjectMocks
    private MealService systemUnderTest;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnCorrectValuesBetweenPricePoints() {
        Mockito.when(mealRepository.findAll())
                .thenReturn(
                        List.of(
                                getMealWithPrice(10),
                                getMealWithPrice(20),
                                getMealWithPrice(30),
                                getMealWithPrice(40),
                                getMealWithPrice(0),
                                getMealWithPrice(-10),
                                getMealWithPrice(-100)));
        List<Meal> result =
                systemUnderTest.getFilteredMeals(
                        20, 40, List.of("Tomato", "Ham", "Mozzarella"), new ArrayList<>());

        assertNotNull(result);
        assertEquals(3, result.size());
        assertMealPrice(result.get(0), 20);
        assertMealPrice(result.get(1), 30);
        assertMealPrice(result.get(2), 40);
    }

    private void assertMealPrice(Meal meal, double price) {
        assertNotNull(meal);
        assertEquals(price, meal.getPrice());
    }

    private Meal getMealWithPrice(double price) {
        String id = UUID.randomUUID().toString();
        return new Meal(id, id, price, List.of("Tomato", "Ham", "Mozzarella"), null);
    }
}

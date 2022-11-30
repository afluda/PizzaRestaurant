package com.example.pizzeramorebackend.repository;

import com.example.pizzeramorebackend.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MealRepository extends JpaRepository<Meal,String> {
    Optional<Meal> findByName(String name);

}

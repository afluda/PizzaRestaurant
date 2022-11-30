package com.example.pizzeramorebackend.mapper;



import com.example.pizzeramorebackend.dto.MealDTO;
import com.example.pizzeramorebackend.models.Meal;
import org.mapstruct.Mapper;

@Mapper
public interface MealMapper {

    Meal fromDTO(MealDTO mealDTO);


    MealDTO toDTO(Meal meal);





}

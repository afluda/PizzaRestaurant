package com.example.pizzeramorebackend.mapper;


import com.example.pizzeramorebackend.dto.CartElementDTO;
import com.example.pizzeramorebackend.models.CartElement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CartElementMapper {
    @Mapping(target = "id", ignore = true)
    CartElement fromDTO(CartElementDTO cartElementDTO);

    CartElementDTO toDTO(CartElement cart);
}

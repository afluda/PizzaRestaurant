package com.example.pizzeramorebackend.mapper;

import com.example.pizzeramorebackend.dto.CartDTO;
import com.example.pizzeramorebackend.models.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CartMapper {
    @Mapping(target = "id", ignore = true)
    Cart fromDTO(CartDTO cartDTO);

    CartDTO toDTO(Cart cart);
}

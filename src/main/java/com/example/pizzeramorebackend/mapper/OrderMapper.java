package com.example.pizzeramorebackend.mapper;


import com.example.pizzeramorebackend.dto.OrderDTO;
import com.example.pizzeramorebackend.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    Order fromDTO(OrderDTO orderDTO);

    OrderDTO toDTO(Order order);
}

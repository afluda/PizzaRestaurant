package com.example.pizzeramorebackend.controllers;


import com.example.pizzeramorebackend.dto.OrderDTO;
import com.example.pizzeramorebackend.mapper.OrderMapper;
import com.example.pizzeramorebackend.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;


    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getFoodOrder() {
        List<OrderDTO> orderList = orderService.getAllOrders().stream().map(orderMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderList);
    }


    @PostMapping()
    public ResponseEntity<OrderDTO> saveFoodOrder(@Valid @RequestBody OrderDTO order) {
        OrderDTO createdOrder = orderMapper.toDTO(orderService.saveOrder(orderMapper.fromDTO(order)));
        return ResponseEntity.status(201).body(createdOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteFoodOrder(@PathVariable String id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok(orderMapper.toDTO(orderService.getOrderById(id)));
    }

    @PutMapping()
    public ResponseEntity<OrderDTO> updateFoodOrder(@Valid @RequestBody OrderDTO order) {
        orderService.updateOrder(orderMapper.fromDTO(order));
        return ResponseEntity.ok(order);
    }


}

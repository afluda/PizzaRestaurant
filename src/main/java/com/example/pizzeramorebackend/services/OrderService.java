package com.example.pizzeramorebackend.services;

import com.example.pizzeramorebackend.models.Order;
import com.example.pizzeramorebackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrderById(String id) {
        orderRepository.deleteById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }


    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }


}

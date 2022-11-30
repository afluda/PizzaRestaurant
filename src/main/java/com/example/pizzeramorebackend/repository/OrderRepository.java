package com.example.pizzeramorebackend.repository;


import com.example.pizzeramorebackend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
}

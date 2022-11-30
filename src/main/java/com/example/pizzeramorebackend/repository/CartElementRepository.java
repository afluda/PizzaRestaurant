package com.example.pizzeramorebackend.repository;

import com.example.pizzeramorebackend.models.CartElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartElementRepository extends JpaRepository<CartElement, String> {

    List<CartElement> findAll();
}

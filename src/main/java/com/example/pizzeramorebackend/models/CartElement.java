package com.example.pizzeramorebackend.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cart_elements")
public class CartElement {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Cart cart;
    @OneToOne(fetch = FetchType.EAGER)
    private Meal meal;

    private int quantity;
}

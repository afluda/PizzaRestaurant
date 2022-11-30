package com.example.pizzeramorebackend.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "meals")
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;

    private double price;
    @ElementCollection
    private List<String> ingredients = new ArrayList<>();
    private String pizzaImage;

    public Meal(String name, double price, List<String> ingredients) {
        this.id = "";
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

}

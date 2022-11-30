package com.example.pizzeramorebackend.models;

import com.example.pizzeramorebackend.models.enums.Role;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User {
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String lastName;
    private String street;
    private String city;
    @Email
    private String email;
    private String password;
    @ElementCollection(targetClass = Role.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Order> orderList = new ArrayList<>();


    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    @PrePersist
    public void prePersist() {
        if (orderList == null) {
            this.orderList = new ArrayList<>();
        }
    }


}

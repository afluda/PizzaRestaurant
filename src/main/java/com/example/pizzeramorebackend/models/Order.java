package com.example.pizzeramorebackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@ToString
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Cart cart;

    @PreRemove
    public void preRemove() {
        this.user = null;
    }

    @PrePersist
    public void prePersist() {
        this.date = new Date();
    }


}

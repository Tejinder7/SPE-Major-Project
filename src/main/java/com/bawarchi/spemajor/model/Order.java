package com.bawarchi.spemajor.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private int orderId;

    private int totalPrice;

    private String timestamp;

    private boolean status;

    @ManyToMany
    private List<Dish> dishList;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name = "table_id")
    private Table table;
}

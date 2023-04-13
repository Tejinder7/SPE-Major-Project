package com.bawarchi.spemajor.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private int cartId;

    private int totalPrice;

    @OneToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany
    private List<Dish> dishList;
}

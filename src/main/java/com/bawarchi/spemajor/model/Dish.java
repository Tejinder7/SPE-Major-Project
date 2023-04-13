package com.bawarchi.spemajor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Dish {
    @Id
    @GeneratedValue
    private int dishId;

    private String name;

    private double price;

    private String category;

    @ManyToOne
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(int dishId, String name, double price, String category, Restaurant restaurant) {
        this.dishId = dishId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.restaurant = restaurant;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", restaurant=" + restaurant +
                '}';
    }
}

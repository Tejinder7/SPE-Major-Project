package com.bawarchi.spemajor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dish {
    @Id
    @GeneratedValue
    private int dishId;

    private String name;

    private double price;

    private String category;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "dishList")
    @JsonIgnore
    private List<AllOrders> allOrdersList;

    public Dish() {
    }

    public Dish(int dishId, String name, double price, String category, Restaurant restaurant, List<AllOrders> allOrdersList) {
        this.dishId = dishId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.restaurant = restaurant;
        this.allOrdersList = allOrdersList;
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

    public List<AllOrders> getAllOrdersList() {
        return allOrdersList;
    }

    public void setAllOrdersList(List<AllOrders> allOrdersList) {
        this.allOrdersList = allOrdersList;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", restaurant=" + restaurant +
                ", orderList=" + allOrdersList +
                '}';
    }
}

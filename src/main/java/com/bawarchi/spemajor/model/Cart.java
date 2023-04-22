package com.bawarchi.spemajor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private int cartId;

    private int dishId;

    private String dishName;

    private int dishPrice;

    private int RestaurantId;

    @ManyToOne
    private User user;

    public Cart() {
    }

    public Cart(int cartId, int dishId, String dishName, int dishPrice, int restaurantId, User user) {
        this.cartId = cartId;
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        RestaurantId = restaurantId;
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        RestaurantId = restaurantId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", dishPrice=" + dishPrice +
                ", RestaurantId=" + RestaurantId +
                ", user=" + user +
                '}';
    }
}

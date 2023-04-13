package com.bawarchi.spemajor.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Restaurant extends User{
    private String name;

    private String contact;

    @ManyToOne
    @JoinColumn(name = "food_court_id")
    private FoodCourt foodCourt;

    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishList;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orderList;

    @OneToMany(mappedBy = "restaurant")
    private List<Cart> cartList;

    public Restaurant() {
    }

    public Restaurant(String name, String contact, FoodCourt foodCourt, List<Dish> dishList, List<Order> orderList, List<Cart> cartList) {
        this.name = name;
        this.contact = contact;
        this.foodCourt = foodCourt;
        this.dishList = dishList;
        this.orderList = orderList;
        this.cartList = cartList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public FoodCourt getFoodCourt() {
        return foodCourt;
    }

    public void setFoodCourt(FoodCourt foodCourt) {
        this.foodCourt = foodCourt;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", foodCourt=" + foodCourt +
                ", dishList=" + dishList +
                ", orderList=" + orderList +
                ", cartList=" + cartList +
                '}';
    }
}

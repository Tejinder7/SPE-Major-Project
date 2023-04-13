package com.bawarchi.spemajor.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends User{
    private String name;

    private String contact;

    @OneToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany
    private List<Order> orderList;

    public Customer() {
    }

    public Customer(String name, String contact, Table table, Cart cart, List<Order> orderList) {
        this.name = name;
        this.contact = contact;
        this.table = table;
        this.cart = cart;
        this.orderList = orderList;
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

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", table=" + table +
                ", cart=" + cart +
                ", orderList=" + orderList +
                '}';
    }
}

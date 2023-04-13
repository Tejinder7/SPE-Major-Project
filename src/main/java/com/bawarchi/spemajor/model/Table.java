package com.bawarchi.spemajor.model;

import jakarta.persistence.*;

@Entity
public class Table {
    @Id
    @GeneratedValue
    private int tableId;

    private int number;

    @ManyToOne
    @JoinColumn(name = "food_court_id")
    private FoodCourt foodCourt;

    @OneToOne(mappedBy = "table")
    private Customer customer;

    @OneToOne(mappedBy = "table")
    private Order order;

    public Table() {
    }

    public Table(int tableId, int number, FoodCourt foodCourt, Customer customer, Order order) {
        this.tableId = tableId;
        this.number = number;
        this.foodCourt = foodCourt;
        this.customer = customer;
        this.order = order;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public FoodCourt getFoodCourt() {
        return foodCourt;
    }

    public void setFoodCourt(FoodCourt foodCourt) {
        this.foodCourt = foodCourt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", number=" + number +
                ", foodCourt=" + foodCourt +
                ", customer=" + customer +
                ", order=" + order +
                '}';
    }
}

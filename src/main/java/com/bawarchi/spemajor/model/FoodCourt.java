package com.bawarchi.spemajor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class FoodCourt extends User{
    private String name;

    private String address;

    private int pincode;

    @OneToMany(mappedBy = "foodCourt")
    private List<Restaurant> restaurantList;

    @OneToMany(mappedBy = "foodCourt")
    private List<Table> tableList;

    public FoodCourt() {
    }

    public FoodCourt(String name, String address, int pincode, List<Restaurant> restaurantList, List<Table> tableList) {
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.restaurantList = restaurantList;
        this.tableList = tableList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    @Override
    public String toString() {
        return "FoodCourt{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                ", restaurantList=" + restaurantList +
                ", tableList=" + tableList +
                '}';
    }
}

package com.bawarchi.spemajor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class User extends userAuth{
    private String name;

    private String contact;

    @OneToMany(mappedBy = "user")
    private List<Cart> cartList;

    public User() {
    }

    public User(String name, String contact, List<Cart> cartList) {
        this.name = name;
        this.contact = contact;
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

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", cartList=" + cartList +
                '}';
    }
}

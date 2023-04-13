package com.bawarchi.spemajor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class SuperAdmin extends User{

    public SuperAdmin() {
    }

    public SuperAdmin(int id, String userId, String password, String role) {
        super(id, userId, password, role);
    }

    @Override
    public String toString() {
        return "SuperAdmin{}";
    }
}

package com.bawarchi.spemajor.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class userAuth {
    @Id
    @GeneratedValue
    @Column(unique = true)
    private int userAuthId;

    @Column(unique = true)
    private String username;

    private String password;

    private String  role;

    public userAuth() {
    }

    public userAuth(int userAuthId, String username, String password, String role) {
        this.userAuthId = userAuthId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserAuthId() {
        return userAuthId;
    }

    public void setUserAuthId(int userAuthId) {
        this.userAuthId = userAuthId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "userAuth{" +
                "userAuthId=" + userAuthId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


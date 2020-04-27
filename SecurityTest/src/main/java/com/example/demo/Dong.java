package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Dong")
public class Dong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String username ;
    private String address;
    private String email;
    private String nameproduct;
    private double price;

    public Dong(int id, String username, String address, String email, String nameproduct, double price) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.email = email;
        this.nameproduct = nameproduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Dong() {
    }

}

package com.berjooj.consumodeapi.models;

import java.util.ArrayList;

public class User {
    public int id;
    public String name;
    public String username;
    public String email;
    public String address;
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public String phone;
    public String website;
    public Company company;
    public Geo geo;

    private ArrayList<Todo> todoList;

    public User(
            int id,
            String name,
            String username,
            String email,
            String address,
            String street,
            String suite,
            String city,
            String zipcode,
            Geo geo,
            String phone,
            String website,
            Company company
    ) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
        this.phone = phone;
        this.website = website;
        this.company = company;

        this.todoList = new ArrayList<>();
    }
}


package com.berjooj.consumodeapi.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<Todo> todoList;
    public ArrayList<Post> postList;

    public User() {
        this.todoList = new ArrayList<>();
        this.postList = new ArrayList<>();
    }

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
            String phone,
            String website
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
        this.phone = phone;
        this.website = website;

        this.todoList = new ArrayList<>();
        this.postList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", todoList=" + todoList.toString() +
                ", postList=" + postList.toString() +
                '}';
    }
}


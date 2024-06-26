package com.example.driverhireapp.model;

import java.io.Serializable;

public class User implements Serializable {



    private String id;
    private String name;
    private String surname;

    private String email;
    private String password;
    private String role;



    public User() {
    }

    public User(String id,String name, String surname, String email,String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = role;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

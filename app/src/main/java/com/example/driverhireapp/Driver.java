package com.example.driverhireapp;

import android.widget.ImageView;

import java.io.Serializable;

public class Driver implements Serializable {

    private String id;
    private String name;
    private String surname;

    private String phoneNumber;

    private String email;

    private ImageView licensePicture;

    private  int yearsOfExperience;

    private int averageRating;

    private String location;

    private String role;

    public Driver(String id, String name, String surname, String phoneNumber, String email, ImageView licensePicture, int yearsOfExperience, int averageRating, String location) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.licensePicture = licensePicture;
        this.yearsOfExperience = yearsOfExperience;
        this.averageRating = averageRating;
        this.location = location;
    }

    public Driver(String id, String name, String surname, String phoneNumber, String email, int yearsOfExperience, String location,String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.yearsOfExperience = yearsOfExperience;
        this.location = location;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ImageView getLicensePicture() {
        return licensePicture;
    }

    public void setLicensePicture(ImageView licensePicture) {
        this.licensePicture = licensePicture;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

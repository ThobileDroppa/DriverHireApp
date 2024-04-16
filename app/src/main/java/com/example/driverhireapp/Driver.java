package com.example.driverhireapp;

import android.widget.ImageView;

import java.io.Serializable;

public class Driver implements Serializable {

    private Long id;
    private String name;
    private String surname;

    private String phoneNumber;

    private ImageView licensePicture;

    private  int yearsOfExperience;

    private int averageRating;

    private String province;

    public Driver(Long id, String name, String surname, String phoneNumber, ImageView licensePicture, int yearsOfExperience, int averageRating, String province) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.licensePicture = licensePicture;
        this.yearsOfExperience = yearsOfExperience;
        this.averageRating = averageRating;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}

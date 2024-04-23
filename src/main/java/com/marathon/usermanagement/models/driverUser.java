package com.marathon.usermanagement.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

public class DriverUser implements User {
    private String username;
    private String password;
    private String dl_info;
    private String make;
    private String model;
    private String color;
    private String plate_number;
    private float rating;
    private Boolean isDriver = true;


    public DriverUser(String username, String password, String dl_info, String make, String model, String color, String plate_number, float rating) {
        this.username = username;
        this.password = password;
        this.dl_info = dl_info;
        this.make = make;
        this.model = model;
        this.color = color;
        this.plate_number = plate_number;
        this.rating = rating;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getDLInfo() {
        return this.dl_info;
    }

    public void setDlInfo(String dl_info) {
        this.dl_info = dl_info;
    }
}
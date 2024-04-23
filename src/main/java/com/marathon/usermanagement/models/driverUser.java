package com.marathon.usermanagement.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class driverUser implements User {
    @Id
    private String username;
    private String password;
    private String dl_info;
    private String make;
    private String model;
    private String color;
    private String plate_number;
    private float rating;

    public driverUser(String username, String password, String dl_info, String make, String model, String color, String plate_number, float rating) {
        this.username = username;
        this.password = password;
        this.dl_info = dl_info;
        this.make = make;
        this.model = model;
        this.color = color;
        this.plate_number = plate_number;
        this.rating = rating;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDLInfo() {
        return this.dl_info;
    }

    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public String getColor() {
        return this.color;
    }
    public String getPlateNumber() {
        return this.plate_number;
    }
    public String getRating() {
        return this.rating;
    }
}
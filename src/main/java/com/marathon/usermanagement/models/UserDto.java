package com.marathon.usermanagement.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class UserDto {
    @Id
    private String username;
    private String password;
    private String dl_info;
    private String make;
    private String model;
    private String color;
    private String plate_number;
    private float rating;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
        this.dl_info = null;
        this.make = null;
        this.model = null;
        this.color = null;
        this.plate_number = null;
        this.rating = 0.0f;
    }

    public UserDto(String username, String password, String dl_info, String make, String model, String color, String plate_number, float rating) {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDLInfo() {
        return this.dl_info;
    }

    public void setDlInfo(String dl_info) {
        this.dl_info = dl_info;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNumber() {
        return this.plate_number;
    }

    public void setPlateNumber(String plate_number) {
        this.plate_number = plate_number;
    }
    
    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
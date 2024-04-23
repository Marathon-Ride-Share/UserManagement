package com.marathon.usermanagement.models;

public class UserDataDto {
    private String username;
    private String dl_info;
    private String make;
    private String model;
    private String color;
    private String plate_number;
    private float rating;

    public UserDataDto(String username, String dl_info, String make, String model, String color, String plate_number, float rating) {
        this.username = username;
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
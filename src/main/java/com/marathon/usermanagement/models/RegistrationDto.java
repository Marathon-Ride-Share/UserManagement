package com.marathon.usermanagement.models;

public class RegistrationDto {
    private String username;
    private String password;
    private String dlInfo;
    private String make;
    private String model;
    private String color;
    private String plateNumber;
    private float rating;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDlInfo() {
        return this.dlInfo;
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

    public Float getRating() {
        return this.rating;
    }

    public boolean isDriver() {
        return dlInfo != null && make != null && model != null && color != null && plateNumber != null && rating != 0.0;
    }
}
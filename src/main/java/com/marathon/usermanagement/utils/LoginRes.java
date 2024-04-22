package com.marathon.usermanagement.utils;

public class LoginRes {
    private String username;
    private boolean isDriver;

    public LoginRes() {
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }
}

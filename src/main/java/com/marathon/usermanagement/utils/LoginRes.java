package com.marathon.usermanagement.utils;

public class LoginRes {
    private String jwt;
    private boolean isDriver;

    public LoginRes() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public boolean getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }
}

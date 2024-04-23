package com.marathon.usermanagement.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@Data
//@AllArgsConstructor
public class LoginRes {
    private String username;
    private boolean isDriver;

    public LoginRes() {
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }
}

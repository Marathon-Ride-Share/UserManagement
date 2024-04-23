package com.marathon.usermanagement.models;

public class RiderUser implements User {
    private String username;
    private String password;
    private Boolean isDriver = false;

    public RiderUser(String username, String password) {
        this.username = username;
        this.password = password;
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

}
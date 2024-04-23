package com.marathon.usermanagement.models;

public class riderUser implements User {
    private String username;
    private String password;

    public riderUser(String username, String password) {
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

    @Override
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }


    public String getDLInfo() {
        return this.dl_info;
    }
}
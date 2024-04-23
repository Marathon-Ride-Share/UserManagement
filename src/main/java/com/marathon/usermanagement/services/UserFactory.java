package com.marathon.usermanagement.services;

import com.marathon.usermanagement.models.driverUser;
import com.marathon.usermanagement.models.riderUser;
import com.marathon.usermanagement.models.User;

public class UserFactory {

    public static User createUser(String username, String password) {
        return new riderUser(username, password);
    }

    public static User createUser(String username, String password, String dl_info, String make, String model, String color, String plate_number, float rating) {
        return new driverUser(username, password, dl_info, make, model, color, plate_number, rating);
    }
}
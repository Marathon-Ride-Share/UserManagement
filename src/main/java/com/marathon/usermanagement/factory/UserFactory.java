package com.marathon.usermanagement.factory;

import com.marathon.usermanagement.models.UserDto;

public class UserFactory {

    public User makeRider(UserDto user) {
        return new riderUser(user.getUsername(), user.getPassword());
    }

    public User makeDriver(UserDto user) {
        return new driverUser(user.getUsername(), user.getPassword(), user.getDLInfo(), user.getMake(), user.getModel(), user.getColor(), user.getPlateNumber(), user.getRating());
    }
}
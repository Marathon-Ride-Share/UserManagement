package com.marathon.usermanagement.factory;

import com.marathon.usermanagement.models.UserDto;
import com.marathon.usermanagement.models.User;
import com.marathon.usermanagement.models.RiderUser;
import com.marathon.usermanagement.models.DriverUser;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User makeRider(UserDto user) {
        return new RiderUser(user.getUsername(), user.getPassword());
    }

    public User makeDriver(UserDto user) {
        return new DriverUser(user.getUsername(), user.getPassword(), user.getDLInfo(), user.getMake(), user.getModel(), user.getColor(), user.getPlateNumber(), user.getRating());
    }
}
package com.marathon.usermanagement.utils;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.marathon.usermanagement.models.UserDto;

public interface UserRepo extends MongoRepository<UserDto, String> {
}
package com.marathon.usermanagement.utils;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.marathon.usermanagement.models.User;

public interface UserRepo extends MongoRepository<User, String> {
}
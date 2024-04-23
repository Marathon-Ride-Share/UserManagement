package com.marathon.usermanagement.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

public interface User {

    public String getUsername();

    public void setUsername();

    public String getPassword();

    public void setPassword();
    
}
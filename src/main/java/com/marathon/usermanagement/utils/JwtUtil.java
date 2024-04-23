package com.marathon.usermanagement.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private String secretKey = System.getenv("JWT_SECRET") != null ? System.getenv("JWT_SECRET") : "jwt-secret";

    private int tokenValidityInSeconds = 36000; 

    public String generateToken(String subject) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + tokenValidityInSeconds * 1000))
                .signWith(SignatureAlgorithm.HS512, secretKey) // Use HS512 algorithm and your secret key
                .compact();
    }
}

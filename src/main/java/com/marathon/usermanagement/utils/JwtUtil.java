package com.marathon.usermanagement.utils;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = System.getenv("JWT_SECRET") != null ? System.getenv("JWT_SECRET") : "marathon-ride-share-applications-secret-key";
    private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    private int tokenValidityInSeconds = 36000; 

    public String generateToken(String subject) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + tokenValidityInSeconds * 1000))
                .signWith(SIGNING_KEY) // Use HS512 algorithm and your secret key
                .compact();
    }
}

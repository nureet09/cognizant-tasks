package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    
    // Generate a secure signing key for HS256 algorithm
    private final Key signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(HttpServletRequest request) {
        LOGGER.info("START - authenticate()");

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.error("Missing or invalid Authorization Header");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing credentials");
        }

        // Extract and Base64 decode the credentials (username:password)
        String base64Credentials = authHeader.substring("Basic ".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);
        
        // Split credentials into user and password tokens
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        LOGGER.debug("Extracted username: {}", username);

        // Validate the credentials against the user:pwd requirement shown in the curl command
        if (!"user".equals(username) || !"pwd".equals(password)) {
            LOGGER.error("Authentication mismatch for user: {}", username);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }

        // Generate the structural JWT token string valid for 30 minutes
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1800000))
                .signWith(signingKey)
                .compact();

        // Package the token payload as a JSON object response match map mapping
        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);

        LOGGER.info("END - authenticate()");
        return response;
    }
}
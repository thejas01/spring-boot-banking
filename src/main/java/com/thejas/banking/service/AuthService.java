package com.thejas.banking.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {



    // Get authenticated user's username from OAuth2 token
    public String getAuthenticatedUsername(org.springframework.security.core.Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        return jwt.getClaim("preferred_username"); // Extract username from token
    }

    // Get authenticated user's roles from OAuth2 token
    public String getAuthenticatedUserRole(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        return jwt.getClaimAsString("roles"); // Extract roles from token
    }

    
}
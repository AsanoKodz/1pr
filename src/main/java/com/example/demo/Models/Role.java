package com.example.demo.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, CASHIER, PURCHASER, MERCHANDISER;

    @Override
    public String getAuthority() {
        return null;
    }
}

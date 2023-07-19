package com.example.back_end.service;

public interface IJWTAuthorization {
    boolean isAdminUser(String authorizationHeader);
    boolean isAdminUserE(String authorizationHeader);
}

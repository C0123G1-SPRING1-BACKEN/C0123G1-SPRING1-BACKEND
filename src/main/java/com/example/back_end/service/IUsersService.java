package com.example.back_end.service;

import com.example.back_end.model.Users;

public interface IUsersService {
    Users findByUsername(String username);
    Users findByEmail(String email);
    void editUser(Users users);

    Users findById(Long id);
    void saveNewPassword(Users users);
}

package com.example.back_end.service.impl;

import com.example.back_end.model.Users;
import com.example.back_end.repository.IUserRepository;
import com.example.back_end.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * Created by: VienH
 * Date created: 13/07/2023
 * Function: Login , Forgot Password
 *
 * @param
 * @return
 */
@Service
public class UsersService implements UserDetailsService, IUsersService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = iUserRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(users.getUsername(), users.getPassword(), new ArrayList<>());
    }

    @Override
    public Users findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Override
    public Users findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public void editUser(Users users) {
        iUserRepository.save(users);
    }

    @Override
    public Users findById(Long id) {
        return iUserRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void saveNewPassword(Users user) {
        Users users = findById(user.getId());
        String password = passwordEncoder.encode(user.getPassword());
        users.setPassword(password);
        iUserRepository.saveNewPassword(users.getId(), users.getPassword());
    }
}

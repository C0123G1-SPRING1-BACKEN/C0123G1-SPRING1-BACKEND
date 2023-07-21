package com.example.back_end.service;

import com.example.back_end.dto.RegisterDTO;


public interface IRegisterPawnService {
    void createRegisterPawn(RegisterDTO registerDTO);


    void confirmRegister(Long id);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}

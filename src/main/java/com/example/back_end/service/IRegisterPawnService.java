package com.example.back_end.service;

import com.example.back_end.dto.RegisterDTO;
import com.example.back_end.model.RegisterPawn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IRegisterPawnService {
    void createRegisterPawn(RegisterDTO registerDTO);

    Page<RegisterPawn> findByNameRegisterPawn(String name, Pageable pageable);



}

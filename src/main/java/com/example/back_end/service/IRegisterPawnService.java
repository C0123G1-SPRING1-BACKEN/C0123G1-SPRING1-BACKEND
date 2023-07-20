package com.example.back_end.service;

import com.example.back_end.dto.RegisterDTO;
import com.example.back_end.model.RegisterPawn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IRegisterPawnService {
    void createRegisterPawn(RegisterDTO registerDTO);

    Page<RegisterPawn> findByNameRegisterPawn(Pageable pageable);



}

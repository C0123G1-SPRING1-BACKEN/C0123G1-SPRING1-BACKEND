package com.example.back_end.service;

import com.example.back_end.dto.RegisterDTO;
import com.example.back_end.model.Customers;
import com.example.back_end.model.RegisterPawn;
import com.example.back_end.repository.IRegisterPawnRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Created by: ThangND
 * Date created: 13/07/2023
 * Function: register pawn
 *
 * @param: register
 * @return
 */
@Service
public class RegisterPawnService implements IRegisterPawnService {

    @Autowired
    private IRegisterPawnRepository registerPawnRepository;


    @Override
    public void createRegisterPawn(@RequestBody RegisterDTO registerDTO) {

        RegisterPawn registerPawn = new RegisterPawn();
        BeanUtils.copyProperties(registerDTO, registerPawn);
        registerPawnRepository.createRegisterPawn(registerPawn.getName(), registerPawn.getPhone(),
                registerPawn.getEmail(), registerPawn.getAddress(), registerPawn.getContendNote(), registerPawn.getProductType().getId());
    }


}

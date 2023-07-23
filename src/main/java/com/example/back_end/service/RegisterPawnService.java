package com.example.back_end.service;

import com.example.back_end.dto.RegisterDTO;
import com.example.back_end.model.Customers;
import com.example.back_end.model.RegisterPawn;
import com.example.back_end.repository.IRegisterPawnRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                registerPawn.getEmail(), registerPawn.getAddress(), registerPawn.getContentNote(), registerPawn.getProductType().getId());
    }

    @Override
    public void confirmRegister(Long id) {
        registerPawnRepository.confirmRegisterPawn(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return registerPawnRepository.existsByEmail(email) ;
    }

    @Override
    public boolean existsByPhone(String phone) {
        return  registerPawnRepository.existsByPhone(phone) ;
    }
    /**
     * Created by: QuocNHA
     * Date created: 13/07/2023
     * Function: register pawn
     *
     * @return
     * @param: register
     */
    @Override
    public Page<RegisterPawn> findByNameRegisterPawn(Pageable pageable) {
        return registerPawnRepository.findByNameRegisterPawn(pageable) ;
    }
}



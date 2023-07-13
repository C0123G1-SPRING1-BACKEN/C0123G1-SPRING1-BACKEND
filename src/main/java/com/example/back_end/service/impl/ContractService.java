package com.example.back_end.service.impl;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.repository.ContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    /**
     * Create by : TriPD
     * Date created : 13/07/2023
     * Function : findContractById(),updateContract()
     * @param : id
     * return: new Contract
     */
    @Autowired
   private ContractRepository contractRepository;


    @Override
    public Optional<Contracts> findContractById(Long id) {
        return contractRepository.findContractById(id);
    }
}

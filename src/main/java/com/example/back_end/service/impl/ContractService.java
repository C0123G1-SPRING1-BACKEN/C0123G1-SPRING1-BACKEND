package com.example.back_end.service.impl;


import com.example.back_end.model.Contracts;
import com.example.back_end.repository.ICreateContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by: DinhHD
 * Date created: 13/07/2023
 * Function: do about pawn interface, customer selection interface
 * <p>
 * // * @param Contracts
 *
 * @return createContract()
 */

@Service
public class ContractService implements IContractService {
    @Autowired
    private ICreateContractRepository iContractRepository;

    @Override
    public List<Contracts> findAll() {
        return iContractRepository.findAllContracts();
    }

    @Transactional
    @Override
    public void createContract(Contracts contracts) {
        iContractRepository.createContract(
                contracts.getCustomer().getId(),
                contracts.getContractCode(),
                contracts.getProductName(),
                contracts.getProductType().getId(),
                contracts.getImage(),
                contracts.getLoans(),
                contracts.getStartDate(),
                contracts.getEndDate(),
                contracts.getProfit(),
                contracts.getContractStatus().getId(),
                contracts.getContractType().getId(),
                contracts.getEmployee().getId());
    }
}

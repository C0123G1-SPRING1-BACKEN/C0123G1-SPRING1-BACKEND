package com.example.back_end.service.impl;


import com.example.back_end.model.Contracts;
import com.example.back_end.repository.IContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by: DinhHD
 * Date created: 13/07/2023
 * Function: do about pawn interface, customer selection interface
 *
// * @param Contracts
 * @return createContract()
 */

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contracts> findAll() {
        return iContractRepository.findAll();
    }

    @Transactional
    @Override
    public void createContract(Contracts contracts) {
        iContractRepository.createContract(contracts.getCustomers().getId(),
                contracts.getContractCode(),
                contracts.getProductName(),
                contracts.getProductType().getId(),
                contracts.getImage(),
                contracts.getLoans(),
                contracts.getStartDate(),
                contracts.getEndDate(),
                contracts.getContractStatus().getId(),
                contracts.getProfit(),
                contracts.getContractType().getId(),
                contracts.getEmployees().getId());

    }
}

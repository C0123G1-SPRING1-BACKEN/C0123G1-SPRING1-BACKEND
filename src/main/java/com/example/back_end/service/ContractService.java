package com.example.back_end.service;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import com.example.back_end.dto.StockDTO;
import com.example.back_end.repository.IContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService{
    @Autowired
    private IContractRepo contractRepo;

    @Override
    public Page<StockDTO> getALLContract(Pageable pageable) {
        return contractRepo.findAllContract(pageable);
    }

    @Override
    public Page<Contracts> findProductInStock(String name, ProductType productType, Pageable pageable) {
        return contractRepo.findProductInStock(name, String.valueOf(productType),pageable);
    }
}

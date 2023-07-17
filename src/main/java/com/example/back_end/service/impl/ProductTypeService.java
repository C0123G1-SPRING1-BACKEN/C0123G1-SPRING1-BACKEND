package com.example.back_end.service.impl;


import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ContractType;
import com.example.back_end.model.ProductType;
import com.example.back_end.repository.IContractStatusRepository;
import com.example.back_end.repository.IContractTypeRepository;
import com.example.back_end.repository.IProductTypeRepository;
import com.example.back_end.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;
    @Autowired
    IContractStatusRepository iContractStatusRepository;
    @Autowired
    IContractTypeRepository iContractTypeRepository;


    @Override
    public List<ProductType> getAll() {
        return iProductTypeRepository.getAll();
    }

    @Override
    public List<ContractStatus> getAllContractStatus() {
        return iContractStatusRepository.findAll();
    }

    @Override
    public List<ContractType> getAllContractType() {
        return iContractTypeRepository.findAll();
    }
}

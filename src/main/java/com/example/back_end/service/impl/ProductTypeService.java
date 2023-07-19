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
    private IContractTypeRepository iContractTypeRepository;

    @Autowired
    private IContractStatusRepository iContractStatusRepository;

    @Override
    public List<ProductType> getAll() {
        return iProductTypeRepository.findAll();
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

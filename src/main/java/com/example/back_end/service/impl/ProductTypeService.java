package com.example.back_end.service.impl;



import com.example.back_end.model.*;
import com.example.back_end.repository.IContractStatusRepository;
import com.example.back_end.repository.IContractTypeRepository;
import com.example.back_end.repository.ICustomerRepository;
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
    private IContractStatusRepository iContractStatusRepository;
    @Autowired
    private IContractTypeRepository iContractTypeRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<ProductType> getAllProductType() {
        return iProductTypeRepository.getAllProductType();
    }

    @Override
    public List<ContractStatus> getAllContractStatus() {
        return iContractStatusRepository.getAllContractStatus();
    }

    @Override
    public List<ContractType> getAllContractType() {
        return iContractTypeRepository.getAllContractType();
    }

    @Override
    public List<Customers> getAllCustomer() {
        return iCustomerRepository.getAllCustomer();
    }


}

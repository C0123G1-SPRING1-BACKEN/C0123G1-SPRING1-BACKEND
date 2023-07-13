package com.example.back_end.service.impl;


import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.Customers;
import com.example.back_end.model.Employees;
import com.example.back_end.model.ProductType;
import com.example.back_end.repository.IContractStatusRepository;
import com.example.back_end.repository.ICustomerRepository;
import com.example.back_end.repository.IEmployeeRepository;
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
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private IContractStatusRepository iContractStatusRepository;


    @Override
    public List<ProductType> findAll() {
        return iProductTypeRepository.findAll();
    }

    @Override
    public List<Customers> findAllCustomer() {
        return iCustomerRepository.findAll();
    }

    @Override
    public List<Employees> findAllEmployee() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public List<ContractStatus> findAllContractStatus() {
        return iContractStatusRepository.findAll();
    }
}

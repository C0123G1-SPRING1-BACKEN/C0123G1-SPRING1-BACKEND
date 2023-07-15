package com.example.back_end.service.impl;

import com.example.back_end.dto.ICustomerDto;

import com.example.back_end.dto.ICustomersDto;
import com.example.back_end.model.Customers;
import com.example.back_end.repository.ICustomerRepository;
import com.example.back_end.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<ICustomerDto> findByCustomer(Pageable pageable) {
        return iCustomerRepository.findByCustomer(pageable);
    }

    @Override
    public Page<ICustomerDto> searchCustomer(Pageable pageable, String name ) {
        return iCustomerRepository.searchCustomer(pageable,name);
    }

    @Override
    public ICustomerDto findByIdCustomer(String id) {
        return iCustomerRepository.findByIdCustomer(id);
    }

    @Override
    public Page<ICustomersDto> findAllCustomer(Pageable pageable) {
        return null;
    }

    @Override
    public Customers findByIdCustomer(Long id) {
        return null;
    }

    @Override
    public Page<ICustomersDto> searchCustomers(Pageable pageable, String name) {
        return null;
    }
}

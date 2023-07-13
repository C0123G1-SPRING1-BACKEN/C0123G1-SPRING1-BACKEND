package com.example.back_end.service.customer.impl;

import com.example.back_end.model.CustomerModel;
import com.example.back_end.model.Customers;
import com.example.back_end.repository.customer.IRepositoryCustomer;
import com.example.back_end.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private IRepositoryCustomer repositoryCustomer;

    @Override
    public Page<Customers> findByNameProduct(String name,Pageable page) {
        return repositoryCustomer.findByNameCustomer(name,page);
    }

    @Override
    public void deleteById(int id) {
        repositoryCustomer.deleteById(id);
    }
}

package com.example.back_end.service.customer.impl;

import com.example.back_end.dto.CustomerListDTO;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.CustomerModel;
import com.example.back_end.model.Customers;
import com.example.back_end.repository.customer.IRepositoryCustomer;
import com.example.back_end.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private IRepositoryCustomer repositoryCustomer;

    @Override
    public Page<CustomerListDTO> findByNameProduct(String name, Pageable page) {
        List<CustomerListDTO> listDTOS = new ArrayList<>();
        Page<Customers> customersPage = repositoryCustomer.findByNameCustomer(name, page);
        CustomerListDTO customerListDTO;
        for (Customers customers : customersPage) {
            customerListDTO = new CustomerListDTO();
            BeanUtils.copyProperties(customers, customerListDTO);
            int quantityContract = 0;
            for (Contracts contract : customers.getContractsSet()) {
                if (!contract.isDelete()) {
                    quantityContract++;
                }
            }
            customerListDTO.setQuantityContract(quantityContract);
            listDTOS.add(customerListDTO);
        }
        return new PageImpl<>(listDTOS, page, customersPage.getTotalElements());
    }

    @Override
    public void deleteById(Long id) {
        Customers customers = repositoryCustomer.findById(id).get();
        customers.setDelete(true);
        repositoryCustomer.save(customers);
    }
}

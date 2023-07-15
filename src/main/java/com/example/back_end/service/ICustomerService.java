package com.example.back_end.service;

import com.example.back_end.dto.ICustomerDto;
import com.example.back_end.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService {
    Page<ICustomerDto> findByCustomer(Pageable pageable);

    Page<ICustomerDto> searchCustomer(Pageable pageable, String name);
    ICustomerDto findByIdCustomer(String id);
}

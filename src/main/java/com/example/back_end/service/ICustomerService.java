package com.example.back_end.service;

import com.example.back_end.dto.ICustomerDto;
import com.example.back_end.model.Customers;
import com.example.back_end.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<ICustomerDto> findAllBySearchCustomer(Pageable pageable, String name);




}

package com.example.back_end.service.customers;

import com.example.back_end.dto.ICustomersDto;
import com.example.back_end.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<ICustomersDto> findAllCustomer(Pageable pageable);
    Customers findByIdCustomer(Long id);
    Page<ICustomersDto> searchCustomer(Pageable pageable,String name);
}

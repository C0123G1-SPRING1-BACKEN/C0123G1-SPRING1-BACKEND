package com.example.back_end.service.customers;

import com.example.back_end.dto.ICustomersDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<ICustomersDto> findAllCustomer(Pageable pageable);
    ICustomersDto findByIdCustomer(String id);
    Page<ICustomersDto> searchCustomer(Pageable pageable,String name);
}

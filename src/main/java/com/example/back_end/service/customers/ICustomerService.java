package com.example.back_end.service.customers;

import com.example.back_end.dto.CustomersDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<CustomersDto> findAllCustomer(Pageable pageable);
}

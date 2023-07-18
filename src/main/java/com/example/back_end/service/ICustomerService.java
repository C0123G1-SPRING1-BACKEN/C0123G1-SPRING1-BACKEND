package com.example.back_end.service;

import com.example.back_end.dto.ICustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<ICustomerDto> findByCustomer(Pageable pageable);

    Page<ICustomerDto> searchCustomer(Pageable pageable, String name);
    ICustomerDto findByIdCustomer(Long id);
}

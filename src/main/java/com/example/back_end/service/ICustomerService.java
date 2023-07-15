package com.example.back_end.service;

import com.example.back_end.dto.IPageCustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<IPageCustomerDto> findByCustomer(Pageable pageable);

    Page<IPageCustomerDto> searchCustomer(Pageable pageable, String name);
    IPageCustomerDto findByIdCustomer(String id);
}

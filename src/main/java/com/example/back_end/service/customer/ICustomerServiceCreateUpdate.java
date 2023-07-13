package com.example.back_end.service.customer;

import com.example.back_end.dto.CustomerSaveDto;

public interface ICustomerServiceCreateUpdate {
    void create(CustomerSaveDto customerSaveDto);
    void update(Long id, CustomerSaveDto customerSaveDto);
    CustomerSaveDto findById(Long id);
}

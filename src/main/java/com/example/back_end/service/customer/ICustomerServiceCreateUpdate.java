package com.example.back_end.service.customer;

import com.example.back_end.dto.CustomerSaveDto;

public interface ICustomerServiceCreateUpdate {
    void createCustomer(CustomerSaveDto customerSaveDto);
    void updateCustomer(Long id, CustomerSaveDto customerSaveDto);
    CustomerSaveDto findByIdCustomer(Long id);

    boolean existsByEmail(String email);

    boolean existsByCitizenCode(String citizenCode);

    boolean existsByPhoneNumber(String phoneNumber);
}

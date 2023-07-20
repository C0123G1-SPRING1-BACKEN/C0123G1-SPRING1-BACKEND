package com.example.back_end.service.customers;

import com.example.back_end.dto.CustomerListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomersService {

    Page<CustomerListDTO> findByNameProduct(String name, Pageable pageable);

    void deleteById(Long id);
}

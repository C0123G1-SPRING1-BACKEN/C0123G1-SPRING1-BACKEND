package com.example.back_end.repository;

import com.example.back_end.dto.CustomersDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ICustomerRepository extends JpaRepository<CustomersDto, Long> {
    @Query(value = "select c.id,c.name, c.phone_number, c.citizen_code, c.quantity_contract from customers c where is_delete=false", nativeQuery = true)
    Page<CustomersDto> finAllCustomer(Pageable pageable);
}

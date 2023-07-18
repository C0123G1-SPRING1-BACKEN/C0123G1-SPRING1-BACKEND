package com.example.back_end.repository;

import com.example.back_end.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customers,Long> {
    @Query(value = "SELECT * FROM customers",nativeQuery = true)
    List<Customers> getAllCustomer();
}

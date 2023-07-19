package com.example.back_end.repository;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.Customers;
import com.example.back_end.model.Employees;
import com.example.back_end.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {


    @Query(value = "SELECT * FROM product_type", nativeQuery = true)
    List<ProductType> getAllProductType();





}

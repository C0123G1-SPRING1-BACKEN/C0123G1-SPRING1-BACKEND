package com.example.back_end.repository;


import com.example.back_end.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query(value = "SELECT k FROM ProductType AS k")
    List<ProductType> findAll();
}

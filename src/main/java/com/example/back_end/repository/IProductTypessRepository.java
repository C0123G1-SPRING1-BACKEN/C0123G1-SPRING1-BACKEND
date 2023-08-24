package com.example.back_end.repository;

import com.example.back_end.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductTypessRepository extends JpaRepository<ProductType, Long> {
    @Query(value = "SELECT * FROM product_type",nativeQuery = true)
    List<ProductType> findAllType();
}

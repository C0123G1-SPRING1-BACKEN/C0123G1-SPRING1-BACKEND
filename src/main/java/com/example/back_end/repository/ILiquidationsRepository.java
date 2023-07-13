package com.example.back_end.repository;

import com.example.back_end.model.Liquidations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ILiquidationsRepository extends JpaRepository<Liquidations, Long> {
    @Query(value = "INSERT INTO liquidation (name,product_name, loans, create_time) VALUES (:name,:product_name, :loans,create_time)", nativeQuery = true)
    void createLiquidations(@Param("name")String name, @Param("product_name")String product_name, @Param("loans")Long loans, @Param("create_time")LocalDateTime create_time);
}

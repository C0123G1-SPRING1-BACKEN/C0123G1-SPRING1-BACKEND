package com.example.back_end.repository;

import com.example.back_end.model.Liquidations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ILiquidationsRepository extends JpaRepository<Liquidations, Long> {
    @Query(value = "INSERT INTO liquidations (customers_id,contracts_id, total_price,create_time) VALUES (:customers_id,:contracts_id, :total_price, :create_time)", nativeQuery = true)
    void createLiquidations(@Param("customers_id")Long customers_id,@Param("contracts_id")Long contracts_id, @Param("total_price")Long total_price,@Param("create_time")LocalDateTime create_time);


}

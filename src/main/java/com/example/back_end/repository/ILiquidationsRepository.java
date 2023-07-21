package com.example.back_end.repository;

import com.example.back_end.model.Liquidations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ILiquidationsRepository extends JpaRepository<Liquidations, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into liquidations (customers_id,products, total_price) values (:customerId, :products, :totalPrice)", nativeQuery = true)
    void createLiquidations(@Param("customerId") Long customerId, @Param("products") String products, @Param("totalPrice") Long totalPrice);


}
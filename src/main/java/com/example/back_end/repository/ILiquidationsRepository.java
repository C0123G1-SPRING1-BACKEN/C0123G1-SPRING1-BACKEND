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
    @Query(value = "insert into liquidations (contracts_id, customers_id, total_price) values (:contractId, :customersId, :totalPrice)", nativeQuery = true)
    void createLiquidations(@Param("contractId") Long contractId, @Param("customersId") Long customersId, @Param("totalPrice") Long totalPrice);


}

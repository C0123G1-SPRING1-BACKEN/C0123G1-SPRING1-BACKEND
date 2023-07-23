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
    @Query(value = "INSERT INTO contracts ( contract_code, contract_type_id, contract_status_id, customers_id, product_name, loans, profit,\n" +
            "                       image, start_date, end_date, product_type_id, link_contracts)\n" +
            "VALUES (:contractCode, :contractTypeId, :contractStatusId, :customerId, :productName, :loans, :profit,\n" +
            "        :image, :startDate, :endDate, :productType, :linkContracts)", nativeQuery = true)
    void createLiquidations(@Param("contractCode") String contractCode, @Param("contractTypeId") Long contractTypeId,
                            @Param("contractStatusId") Long contractStatusId, @Param("customerId") Long customerId,
                            @Param("productName") String productName, @Param("loans") Long loans, @Param("profit") Long profit,
                            @Param("image") String image,@Param("startDate") String startDate,@Param("endDate") String endDate, @Param("productType") Long productType
            , @Param("linkContracts") String linkContracts);


}
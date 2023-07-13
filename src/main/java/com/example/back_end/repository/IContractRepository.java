package com.example.back_end.repository;

import com.example.back_end.model.Contracts;
import com.example.back_end.projections.IContractProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IContractRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "SELECT c.id AS id ,c.contract_code AS contractCode,c.product_name AS productName," +
            "c.customers_id AS customers, c.start_date AS startDate,c.contract_type_id AS contractType," +
            "c.contract_status_id AS contractStatus FROM contracts AS c" +
            "    WHERE c.is_delete = false", nativeQuery = true)
    Page<IContractProjection> findAllTransactionHistoryByDeleteIsFalse(Pageable pageable);

    @Query(value = "SELECT * FROM contracts AS c" +
            "    WHERE c.is_delete = false AND c.id=:contract_id", nativeQuery = true)
    Optional<Contracts> findContractsById(@Param("contract_id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "UPDATE contracts AS c SET  c.is_delete=true WHERE c.id=:id", nativeQuery = true)
    void deleteContractById(@Param("id") Integer id);


    @Query(value = "SELECT c.id AS id ,c.contract_code AS contractCode,c.product_name AS productName," +
            "c.customers_id AS customers, c.start_date AS startDate,c.contract_type_id AS contractType," +
            "c.contract_status_id AS contractStatus FROM contracts AS c" +
            "WHERE c.is_delete = false AND c.id=:contract_id", nativeQuery = true)
    Page<IContractProjection> searchTransactionHistory(@Param("contract_id") Integer id);
}

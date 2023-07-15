package com.example.back_end.repository;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractsRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "SELECT c.id as contractId, c.product_name as productName, p.name as productType, c.loans as loans, (SELECT COUNT(*)  FROM contracts GROUP BY id)" +
            " AS total FROM contracts c JOIN product_type p ON c.product_type_id = p.id WHERE c.contract_status_id = 3 ", nativeQuery = true)
    Page<IContractDto> finAllProduct(Pageable pageable);

    @Query(value = "SELECT *\n" +
            "            FROM contracts c\n" +
            "            WHERE c.id = :id\n" +
            "             AND c.is_delete = FALSE\n" +
            "          AND c.contract_status_id = 3", nativeQuery = true)
    Contracts findContractById(Long id);

    @Query(value = "select c.id,c.product_name                               as productName,\n" +
            "       c.product_type_id                            as productType,\n" +
            "       c.loans                                      as loans,\n" +
            "       (SELECT COUNT(*) FROM contracts GROUP BY id) AS total\n" +
            "from contracts c\n" +
            "where c.product_name like :productName\n" +
            "  and c.product_type_id = :productType\n" +
            "  and c.loans like :loans", nativeQuery = true)
    Page<IContractDto> searchProduct(Pageable pageable, @Param("productName") String productName, @Param("productType") String productType, @Param("loans") String loans);
}


package com.example.back_end.repository;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractsRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "SELECT c.id AS id, c.product_name AS productName, p.name AS productType, c.loans AS loans\n" +
            "FROM contracts c\n" +
            "JOIN product_type p ON c.product_type_id = p.id\n" +
            "WHERE c.contract_status_id = 3 and is_delete =false", nativeQuery = true)
    Page<IContractDto> finAllProduct(Pageable pageable);

    @Query(value = "SELECT c.id as id,c.product_name as productName,c.product_type_id as productType, c.loans as loans, (SELECT COUNT(*)  FROM contracts GROUP BY id) AS total\n" +
            "            FROM contracts c\n" +
            "            WHERE c.id = :id\n" +
            "             AND c.is_delete = FALSE\n" +
            "          AND c.contract_status_id = 3", nativeQuery = true)
    IContractDto findContractById(Long id);

    @Query(value = "SELECT c.product_name AS productName, pt.name AS productType, c.loans as loans\n" +
            "FROM contracts c\n" +
            "         inner join product_type pt on c.product_type_id = pt.id\n" +
            "WHERE c.product_name LIKE concat('%', :productName, '%')\n" +
            "  AND pt.id LIKE concat('%', :productType, '%')\n" +
            "  AND c.loans between :startIndex AND :endIndex", nativeQuery = true)
    Page<IContractDto> searchProduct(Pageable pageable, @Param("productName") String productName, @Param("productType") String productType, @Param("startIndex") String  startIndex, @Param("endIndex") String  endIndex);
}


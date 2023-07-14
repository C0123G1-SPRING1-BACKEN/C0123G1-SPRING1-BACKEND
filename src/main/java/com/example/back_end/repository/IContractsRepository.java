package com.example.back_end.repository;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.dto.ICustomersDto;
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
    @Query(value = "SELECT c.product_name\n" +
            "            FROM contracts c\n" +
            "            WHERE c.id = :id\n" +
            "             AND c.is_delete = FALSE\n" +
            "          AND c.contract_status_id = 3", nativeQuery = true)
    IContractDto findContractById(Long id);

    @Query(value = "select c.product_name,c.product_type_id,c.loans, (SELECT COUNT(*)  FROM contracts GROUP BY id) AS total from contracts c where c.product_name like :product_name and c.product_type_id= :product_type_id and c.loans= :loans",nativeQuery = true)
    Page<IContractDto> searchProduct(Pageable pageable, @Param("product_name")String product_name,@Param("product_type_id")String product_type_id,@Param("loans")Long loans);
}


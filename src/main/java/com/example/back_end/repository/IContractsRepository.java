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
    @Query(value = "SELECT c.name,c.phone_number,c.citizen_code,c.quantity_contract\n" +
            "FROM contracts\n" +
            "         INNER JOIN customers c ON contracts.customers_id = c.id\n" +
            "WHERE c.id = :id\n" +
            "  AND c.is_delete = FALSE\n" +
            "  AND contracts.contract_status_id = 3", nativeQuery = true)
    IContractDto findContractById(String id);

    @Query(value = "select c.name,c.phone_number,c.citizen_code,c.quantity_contract from customers c where c.name like :%name%",nativeQuery = true)
    Page<ICustomersDto> searchCustomer(Pageable pageable, @Param("name")String name);
}


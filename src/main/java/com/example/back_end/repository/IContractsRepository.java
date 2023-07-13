package com.example.back_end.repository;

import com.example.back_end.dto.ContractsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractsRepository extends JpaRepository<ContractsDto, Long> {
    @Query(value = "SELECT c.product_name, p.name, c.loans, (SELECT COUNT(*) FROM contracts GROUP BY product_name) AS total FROM contracts c JOIN product_type p ON c.id = p.id WHERE c.contract_status_id = 3 ", nativeQuery = true)
    Page<ContractsDto> finAllProduct(Pageable pageable);
}


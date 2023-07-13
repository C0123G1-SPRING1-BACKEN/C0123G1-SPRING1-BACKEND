package com.example.back_end.repository;

import com.example.back_end.model.Contracts;
import com.example.back_end.projections.ContractDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "SELECT c.id,\n" +
            "    c.contract_code,\n" +
            "    c.product_name,\n" +
            "    c.customers_id,\n" +
            "    c.start_date,\n" +
            "    c.contract_type_id,\n" +
            "    c.contract_status_id\n" +
            "FROM contracts AS c\n" +
            "    LEFT JOIN contract_status cs on cs.id = c.contract_status_id\n" +
            "    LEFT JOIN contracts c2 on cs.id = c2.contract_status_id\n" +
            "    LEFT JOIN contract_type ct on c.contract_type_id = ct.id\n" +
            "    INNER JOIN customers c3 on c.customers_id = c3.id\n" +
            "WHERE c.is_delete = false", nativeQuery = true)
    Page<ContractDTO> findAllByDeleteIsFalse(Pageable pageable);
}

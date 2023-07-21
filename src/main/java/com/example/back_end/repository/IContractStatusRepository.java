package com.example.back_end.repository;


import com.example.back_end.model.ContractStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IContractStatusRepository extends JpaRepository<ContractStatus,Long> {
    @Query(value = "SELECT * FROM contract_status",nativeQuery = true)
    List<ContractStatus> getAllContractStatus();

    Optional<ContractStatus> findById(Long id);
}

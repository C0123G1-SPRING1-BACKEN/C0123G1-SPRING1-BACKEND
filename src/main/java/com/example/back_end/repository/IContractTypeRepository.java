package com.example.back_end.repository;

import com.example.back_end.model.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractTypeRepository extends JpaRepository< ContractType, Long> {
    @Query(value = "SELECT * FROM contract_type", nativeQuery = true)
    List<ContractType> getAllContractType();
}

package com.example.back_end.repository;

import com.example.back_end.model.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IContractTypeRepository extends JpaRepository< ContractType, Long> {
    @Query(value = "SELECT * FROM contract_type", nativeQuery = true)
    List<ContractType> getAllContractType();

    Optional<ContractType> findById(Long id);


}

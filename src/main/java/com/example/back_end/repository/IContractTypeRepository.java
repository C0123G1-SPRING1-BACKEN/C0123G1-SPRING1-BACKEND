package com.example.back_end.repository;

import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractTypeRepository extends JpaRepository<ContractType,Long> {
    @Query(value = "SELECT p FROM ContractType AS p")
    List<ContractType> findAll();
}

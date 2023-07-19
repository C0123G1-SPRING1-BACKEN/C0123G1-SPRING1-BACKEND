package com.example.back_end.repository;


import com.example.back_end.model.ContractStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractStatusRepository extends JpaRepository<ContractStatus, Integer> {
    @Query(value = "SELECT p FROM ContractStatus AS p")
    List<ContractStatus> findAll();
}

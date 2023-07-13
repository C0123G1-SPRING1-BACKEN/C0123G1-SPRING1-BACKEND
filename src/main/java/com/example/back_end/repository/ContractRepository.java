package com.example.back_end.repository;

import com.example.back_end.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contracts,Long> {
    @Query(value = "SELECT citizen_code,Customers.name,Customers.front_citizen,Customers.back_citizen,product_name,start_date,end_date from contracts JOIN customers ON contracts.customers_id = customers.id WHERE Contracts.id= :id",nativeQuery = true)
    Optional<Contracts> findContractById(@Param("id") Long id);
}

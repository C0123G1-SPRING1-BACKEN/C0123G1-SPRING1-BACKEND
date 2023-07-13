package com.example.back_end.repository;


import com.example.back_end.dto.CustomerDto;
import com.example.back_end.dto.ICustomerDto;
import com.example.back_end.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customers,Long> {
//    @Query(value = "SELECT p FROM Customers AS p")
//    List<Customers> findAll();
        @Query(value = "SELECT c.id as id,c.name as name,c.citizen_code as citizenCode FROM customers as c  ",
             nativeQuery = true)
    Page<ICustomerDto>findByCustomer(Pageable pageable);
    @Query(value = "SELECT c.id as id,c.name as name,c.citizen_code as citizenCode FROM customers as c WHERE c.name Like concat('%',:name,'%') ",
            nativeQuery = true)
    Page<ICustomerDto>searchCustomer(Pageable pageable, @Param("name")String name);
}

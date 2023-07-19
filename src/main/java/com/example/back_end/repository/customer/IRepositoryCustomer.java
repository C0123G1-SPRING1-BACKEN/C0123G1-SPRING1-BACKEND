package com.example.back_end.repository.customer;

import com.example.back_end.model.CustomerModel;
import com.example.back_end.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by: QuocNHA
 * Date created: 13/07/2023
 * Function: customer pawn
 * @return
 */
@Repository
public interface IRepositoryCustomer extends JpaRepository<Customers,Long> {

    @Query(value = "select * from customers where name LIKE CONCAT('%', :name, '%') and is_delete = false", nativeQuery = true)
    Page<Customers> findByNameCustomer(@Param("name")String name, Pageable pageable);

}


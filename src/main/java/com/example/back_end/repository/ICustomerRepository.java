package com.example.back_end.repository;

import com.example.back_end.dto.ICustomerDto;
import com.example.back_end.dto.ICustomersDto;
import com.example.back_end.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customers, Long> {
    @Query(value = "select c.id as customerId ,c.name as customerName, c.phone_number as phoneNumber, c.citizen_code as citizenCode, c.quantity_contract as quantityContract from customers c where is_delete=false", nativeQuery = true)
    Page<ICustomersDto> finAllCustomer(Pageable pageable);
    @Query(value = "SELECT * FROM customers c where c.id = 1\n" +
            "             AND c.is_delete = FALSE", nativeQuery = true)
    Customers findCustomersById(Long id);

    @Query(value = "select c.id,c.name as customerName ,c.phone_number as phoneNumber,c.citizen_code as citizenCode,c.quantity_contract as quantityContract from customers c where c.name like :name",nativeQuery = true)
    Page<ICustomerDto> searchCustomer(Pageable pageable, @Param("name")String name);



    @Query(value = "SELECT c.id as id,c.name as name,c.citizen_code as citizenCode FROM customers as c  ",
            nativeQuery = true)
    Page<ICustomerDto> findByCustomer(Pageable pageable);


    @Query(value = "SELECT c.id as id,c.name as name,c.citizen_code as citizenCode FROM customers as c WHERE c.id=:id",nativeQuery = true)
    ICustomerDto findByIdCustomer(@Param("id")String id );
    @Query(value = "SELECT c.id as id,c.name as name,c.citizen_code FROM customers as c WHERE c.name LIKE concat('%',:name,'%') ",
            nativeQuery = true)
    Page<ICustomersDto> searchCustomers(Pageable pageable, @Param("name") String name);
}

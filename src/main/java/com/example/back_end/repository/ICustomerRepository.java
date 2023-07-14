package com.example.back_end.repository;

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
    @Query(value = "SELECT c.name,c.phone_number,c.citizen_code,c.quantity_contract\n" +
            "FROM contracts\n" +
            "         INNER JOIN customers c ON contracts.customers_id = c.id\n" +
            "WHERE c.id = :id\n" +
            "  AND c.is_delete = FALSE\n" +
            "  AND contracts.contract_status_id = 3", nativeQuery = true)
    ICustomersDto findCustomersById(String id);

    @Query(value = "select c.name,c.phone_number,c.citizen_code,c.quantity_contract from customers c where c.name like :%name%",nativeQuery = true)
    Page<ICustomersDto> searchCustomer(Pageable pageable, @Param("name")String name);
}

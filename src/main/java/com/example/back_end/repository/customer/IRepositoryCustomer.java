package com.example.back_end.repository.customer;

import com.example.back_end.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCustomer extends JpaRepository<Customers,Long> {

//    @Query(value = "update ticket set is_delete = true where id_ticket = :id_ticket", nativeQuery = true)
//    void cancelTicket(@Param("id_ticket") Integer id);
//
//    @Query(value = "select customer.name,customer.birthday,customer.gender,customer.phone,customer.email,customer.address,customer.idCard,customer.img ,customer.frondCard,customer.backCard,customer.createDate,customer.updateDate,count(contracts.customer_id) as quantityContract" +
//            "from customer" +
//            "join contract on customer.id=contract.id_customer" +
//            "where name like %:name% ",
//            nativeQuery = true)
//    Page<CustomerModel> findAllCustomer(Pageable pageable, @Param("name") String name);
    @Query(value = "select * from customers where name LIKE CONCAT('%', :name, '%') and is_delete = false", nativeQuery = true)
    Page<Customers> findByNameCustomer(@Param("name")String name, Pageable pageable);
//    @Query(value = "select * from customers", nativeQuery = true)
//    Page<Customers> findByNameCustomer(Pageable pageable);
}


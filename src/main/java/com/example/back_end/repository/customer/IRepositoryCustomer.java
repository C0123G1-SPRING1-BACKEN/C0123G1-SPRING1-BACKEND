package com.example.back_end.repository.customer;

import com.example.back_end.model.CustomerModel;
import com.example.back_end.model.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface IRepositoryCustomer extends JpaRepository<Customers,Integer> {

//    @Query(value = "update ticket set is_delete = true where id_ticket = :id_ticket", nativeQuery = true)
//    void cancelTicket(@Param("id_ticket") Integer id);
//
//    @Query(value = "select customer.name,customer.birthday,customer.gender,customer.phone,customer.email,customer.address,customer.idCard,customer.img ,customer.frondCard,customer.backCard,customer.createDate,customer.updateDate,count(contracts.customer_id) as quantityContract" +
//            "from customer" +
//            "join contract on customer.id=contract.id_customer" +
//            "where name like %:name% ",
//            nativeQuery = true)
//    Page<Customers> findByNameCustomer(@Param("name")String name, Pageable pageable);

    @Query(value = "select c.`name`,c.birthday,c.gender,c.phone_number,c.email,c.address,c.front_citizen,c.image,c.back_citizen,c.create_date,c.update_date,count(ct.customers_id) \n" +
            "           as quantityContract\n" +
            "           from customers c\n" +
            "           join contracts ct on c.id=ct.customers_id\n" +
            "           where c.`name`  LIKE CONCAT('%', :name, '%')\n" +
            "           group by ct.customers_id;", nativeQuery = true)
    Page<Customers> findByNameCustomer(@Param("name")String name, Pageable pageable);
//    @Query(value = "select * from customers", nativeQuery = true)
//    Page<Customers> findByNameCustomer(Pageable pageable);


    @Query(value = "delete from customers where id = :id",nativeQuery = true)
    void deleteCustomers(int id);
}


package com.example.back_end.repository;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface ContractRepository extends JpaRepository<Contracts,Long> {
    @Query(value = "SELECT * from contracts JOIN customers ON contracts.customers_id = customers.id\n" +
            "JOIN contract_status cs on contracts.contract_status_id = cs.id\n" +
            "JOIN contract_type ct on contracts.contract_type_id = ct.id\n" +
            "JOIN employees e on contracts.employees_id = e.id\n" +
            "JOIN product_type pt on contracts.product_type_id = pt.id WHERE contracts.id= :id",nativeQuery = true)
    Optional<Contracts> findContractById(@Param("id") Long id);
    @Query(value = "select * from contracts order by create_date desc  limit 10;", nativeQuery = true)
    List<Contracts> showTop10NewContract();
//    @Query(value = "UPDATE Contracts SET product_name = :productName, contract_code = :contractCode, loans = :loans, profit = :profit, image = :image, start_date = :startDate, end_date = :endDate,create_date= :createDate, update_date = :updateDate, is_delete = :isDelete, product_type_id = :productType.id, customers_id = :customers, contract_status_id = :contractStatus, employees_id = :employees, contract_type_id = :contractType WHERE id = :id",nativeQuery = true)
//    void saveContract(String productName, String contractCode, Long loans, Long profit, String image, String startDate, String endDate, LocalDateTime createDate, LocalDateTime updateDate, boolean  isDelete,@Param("id") Long id);
    @Query(value = "UPDATE Contracts SET contract_code = :contractCode,product_name = :productName, loans = :loans, profit = :profit, image = :image, start_date = :startDate, end_date = :endDate,create_date= :createDate, update_date = :updateDate, is_delete = :isDelete, product_type_id = :productTypeId, customers_id = :customerId, contract_status_id = :contractStatusId, employees_id = :employeeId, contract_type_id = :contractTypeId WHERE id = :id",nativeQuery = true)
    void saveContract(  String contractCode,String productName, Long loans, Long profit, String image, String startDate, String endDate, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete, Long productTypeId, Long customerId, Long contractStatusId, Long employeeId, Long contractTypeId, Long id);
}

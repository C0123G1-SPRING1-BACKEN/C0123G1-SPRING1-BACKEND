package com.example.back_end.repository;

import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "SELECT * from contracts JOIN customers ON contracts.customers_id = customers.id\n" +
            "JOIN contract_status cs on contracts.contract_status_id = cs.id\n" +
            "JOIN contract_type ct on contracts.contract_type_id = ct.id\n" +
            "JOIN employees e on contracts.employees_id = e.id\n" +
            "JOIN product_type pt on contracts.product_type_id = pt.id WHERE contracts.id= :id", nativeQuery = true)
    Contracts findContractById(@Param("id") Long id);

    @Query(value = "select * from contracts order by create_date desc  limit 10;", nativeQuery = true)
    List<Contracts> showTop10NewContract();

    @Transactional
    @Query(value = "UPDATE Contracts SET id= :id,contract_code = :contractCode,product_name = :productName, loans = :loans, profit = :profit, image = :image, start_date = :startDate, end_date = :endDate, is_delete = :isDelete, product_type_id = :productTypeId, customers_id = :customerId, contract_status_id = :contractStatusId, employees_id = :employeeId, contract_type_id = :contractTypeId WHERE Contracts.id = :id", nativeQuery = true)
    Contracts saveContract(@Param("id")Long id ,@Param("contractCode") String contractCode,@Param("productName") String productName,@Param("loans") Long loans,
                           @Param("profit") Long profit,@Param("image") String image,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("isDelete") boolean isDelete,
                           @Param("productTypeId") Long productTypeId,@Param("customerId") Long customerId,@Param("contractStatusId") Long contractStatusId,@Param("employeeId") Long employeeId,@Param("contractTypeId") Long contractTypeId);

}

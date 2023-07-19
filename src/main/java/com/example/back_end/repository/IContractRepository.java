package com.example.back_end.repository;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.model.Contracts;

import com.example.back_end.model.Contracts;
import com.example.back_end.projections.IContractProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IContractRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "SELECT * from contracts where contracts.is_delete=false and contracts.id= :id", nativeQuery = true)
    Contracts findContractById(@Param("id") Long id);

    @Query(value = "select * from contracts where contracts.is_delete=false", nativeQuery = true)
    Page<Contracts> showTop10NewContract(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Contracts SET contract_code = :contractCode,product_name = :productName, loans = :loans, profit = :profit, image = :image, start_date = :startDate, end_date = :endDate, is_delete = :isDelete, product_type_id = :productTypeId, customers_id = :customerId, contract_status_id = :contractStatusId, employees_id = :employeeId, contract_type_id = :contractTypeId WHERE Contracts.id = :id", nativeQuery = true)
    void saveContract(@Param("contractCode")String contractCode,@Param("productName") String productName,@Param("loans") Long loans,
                           @Param("profit") Long profit,@Param("image") String image,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("isDelete") boolean isDelete,
                           @Param("productTypeId") Long productTypeId,@Param("customerId") Long customerId,@Param("contractStatusId") Long contractStatusId,@Param("employeeId") Long employeeId,@Param("contractTypeId") Long contractTypeId,@Param("id")Long id);



    @Query(value = "SELECT c.id AS id ,c.contract_code AS contractCode,c.product_name AS productName," +
            "c.customers_id AS customers, c.start_date AS startDate,c.contract_type_id AS contractType," +
            "c.contract_status_id AS contractStatus FROM contracts AS c" +
            " WHERE c.is_delete = false", nativeQuery = true)
    Page<IContractProjection> findAllTransactionHistoryByDeleteIsFalse(Pageable pageable);

    @Query(value = "SELECT * FROM contracts AS c" +
            "    WHERE c.is_delete = false AND c.id=:contract_id", nativeQuery = true)
    Optional<Contracts> findContractsById(@Param("contract_id") Long id);


    @Transactional
    @Modifying
    @Query(value = "UPDATE contracts AS c SET  c.is_delete=true WHERE c.id=:id", nativeQuery = true)
    void deleteContractById(@Param("id") Long id);



        @Query(value = "SELECT c.id                 AS id," +
                "       c.contract_code      AS contractCode," +
                "       c.product_name       AS productName," +
                "       c.customers_id       AS customers," +
                "       c.start_date         AS startDate," +
                "       c.contract_type_id   AS contractType," +
                "       c.contract_status_id AS contractStatus," +
                "  c2.name" +
                " FROM contracts AS c" +
                "         INNER JOIN customers c2 ON c.customers_id = c2.id" +
                " WHERE c.is_delete = false AND c.product_name like :product_names" +
                "  OR (c.start_date BETWEEN :from_date AND :to_date)" +
                "   AND c2.name LIKE :customer_name" +
                "   AND c.contract_type_id = :type_id" +
                "   AND c.contract_status_id = :status_id", nativeQuery = true)
        Page<IContractProjection> searchTransactionHistory(Pageable pageable, @Param("customer_name") String customerName,
                                                           @Param("product_names") String productNames,
                                                           @Param("from_date") String fromDate,
                                                           @Param("to_date") String toDate,
                                                           @Param("type_id") Long typeId,
                                                           @Param("status_id") Long statusId);

        @Query(value = "SELECT p FROM Contracts AS p")
        List<Contracts> findAllContracts();

        @Transactional
        @Modifying
        @Query(value = "INSERT INTO contracts(customer_id,contract_code,product_name,product_type_id,image,loans,start_date,end_date,profit,contract_status_id,contract_type_id,employee_id) " +
                "VALUES (:customerId,:contractCode,:productName,:productTypeId,:image,:loans,:startDate,:endDate,:profit,:contractStatusId,:contractTypeId,:employeeId)", nativeQuery = true)
        void createContract(@Param("customerId") Long customerId, @Param("contractCode") String contractCode,
                            @Param("productName") String productName, @Param("productTypeId") Long productTypeId,
                            @Param("image") String image, @Param("loans") Long loans, @Param("startDate") String startDate,
                            @Param("endDate") String endDate, @Param("profit") Long profit, @Param("contractStatusId") Long contractStatusId,
                            @Param("contractTypeId") Long contractTypeId, @Param("employeeId") Long employeeId);



}


//    double soTienVay = 10000000; // Số tiền vay
//    double laiSuatNgay = 0.00065; // Lãi suất hàng ngày (0.065%)
//    LocalDate ngayVay = LocalDate.of(2023, 7, 1); // Ngày vay
//    LocalDate ngayTra = LocalDate.of(2023, 8, 1); // Ngày trả
//
//    long soNgayVay = ChronoUnit.DAYS.between(ngayVay, ngayTra); // Số ngày vay
//
//    double tienLai = soTienVay * laiSuatNgay * soNgayVay; // Tiền lãi
//
//            System.out.println("Tiền lãi: " + tienLai);


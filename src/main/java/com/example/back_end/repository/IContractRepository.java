package com.example.back_end.repository;


import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.Contracts;
import com.example.back_end.projections.IContractProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IContractRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "SELECT c.id AS id ,c.contract_code AS contractCode,c.product_name AS productName," +
            "c.customers_id AS customers, c.start_date AS startDate,c.contract_type_id AS contractType," +
            "c.contract_status_id AS contractStatus FROM contracts AS c" +
            " WHERE c.is_delete = false", nativeQuery = true)
    Page<IContractProjection> findAllTransactionHistoryByDeleteIsFalse(Pageable pageable);

    @Query(value = "SELECT * FROM contracts AS c" +
            "    WHERE c.is_delete = false AND c.id=:contract_id", nativeQuery = true)
    Optional<Contracts> findContractsById(@Param("contract_id") Integer id);


    @Transactional
    @Modifying
    @Query(value = "UPDATE contracts AS c SET  c.is_delete=true WHERE c.id=:id", nativeQuery = true)
    void deleteContractById(@Param("id") Integer id);


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




    @Transactional
    @Modifying
    @Query(value = "INSERT INTO contracts(customers_id,contract_code,product_name,product_type_id,image,loans,start_date,end_date,profit,contract_status_id,contract_type_id,employees_id) " +
            "VALUES (:customers,:contractCode,:productName,:productType,:image,:loans,:startDate,:endDate,:profit,1,1,:employees)", nativeQuery = true)
    void createContract(@Param("customers") Long customers, @Param("contractCode") String contractCode,
                        @Param("productName") String productName, @Param("productType") Long productType,
                        @Param("image") String image, @Param("loans") Long loans, @Param("startDate") String startDate,
                        @Param("endDate") String endDate, @Param("profit") Long profit, @Param("employees") Long employees);
    @Query(value = "SELECT * FROM contracts ",nativeQuery = true)
    List<Contracts> findAll();
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
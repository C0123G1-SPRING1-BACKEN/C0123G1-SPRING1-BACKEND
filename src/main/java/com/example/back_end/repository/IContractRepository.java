package com.example.back_end.repository;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.model.Contracts;


import com.example.back_end.projections.ITransactionHistoryProjection;
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
            "c2.name AS customers, c.start_date AS startDate,ct.name AS contractType," +
            "cs.name AS contractStatus FROM contracts AS c" +
            " INNER JOIN contract_type AS ct ON ct.id = c.contract_type_id" +
            " INNER JOIN contract_status AS cs ON cs.id = c.contract_status_id" +
            " INNER JOIN customers c2 on c.customer_id = c2.id " +
            " WHERE c.is_delete = false ORDER BY start_date desc ", nativeQuery = true)
    Page<ITransactionHistoryProjection> findAllTransactionHistoryByDeleteIsFalse(Pageable pageable);

    @Query(value = "SELECT c.id , c.contract_code,c.create_time,c.end_date,c.image," +
            " c.is_delete,c.loans,c.product_name, c.profit,c.start_date,c.update_time,c.contract_status_id,c.contract_type_id,c.customer_id," +
            " c.employee_id, c.product_type_id " +
            "   FROM contracts AS c" +
            "    WHERE c.is_delete = false AND c.contract_code=:contract_id", nativeQuery = true)
    Optional<Contracts> findContractsById(@Param("contract_id") String id);


    @Transactional
    @Modifying
    @Query(value = "UPDATE contracts AS c SET  c.is_delete=true WHERE c.contract_code=:id", nativeQuery = true)
    void deleteContractById(@Param("id") String id);


    @Query(value = "SELECT c.id            AS id,\n" +
            "       c.contract_code AS contractCode,\n" +
            "       c.product_name  AS productName,\n" +
            "       c2.name         AS customers,\n" +
            "       c.start_date    AS startDate,\n" +
            "       ct.name         AS contractType,\n" +
            "       cs.name         AS contractStatus\n" +
            "FROM contracts AS c\n" +
            "         INNER JOIN contract_type AS ct ON ct.id = c.contract_type_id\n" +
            "         INNER JOIN contract_status AS cs ON cs.id = c.contract_status_id\n" +
            "         INNER JOIN customers c2 ON c.customer_id = c2.id\n" +
            "WHERE c.is_delete = false\n" +
            "  AND c.product_name LIKE concat('%', :product_names, '%')\n" +
            "  AND c2.name LIKE concat('%', :customer_name, '%')\n" +
            "  AND c.contract_type_id LIKE concat('%', :type_id, '%')\n" +
            "    AND c.contract_status_id LIKE concat('%', :status_id, '%')\n" +
            "    AND (CASE\n" +
            "                      WHEN :from_date = '' AND :to_date = '' THEN c.start_date LIKE '%%'\n" +
            "                    WHEN :from_date = ''  AND :to_date != '' THEN c.start_date = :to_date\n" +
            "                       WHEN :to_date = ''  AND :from_date != '' THEN c.start_date = :from_date\n" +
            "                        ELSE c.start_date BETWEEN COALESCE(:from_date, c.start_date) AND COALESCE(:to_date, c.start_date)\n" +
            "                 END)" +
            "ORDER BY c.start_date DESC ",
            countQuery = "select count(*)" +
                    "FROM contracts AS c" +
                    "                    INNER JOIN contract_type AS ct ON ct.id = c.contract_type_id" +
                    "                 INNER JOIN contract_status AS cs ON cs.id = c.contract_status_id" +
                    "                   INNER JOIN customers c2 ON c.customer_id = c2.id" +
                    "          WHERE c.is_delete = false" +
                    "           AND c.product_name LIKE concat('%', :product_names, '%')" +
                    "            AND c2.name LIKE concat('%', :customer_name, '%')" +
                    "          AND c.contract_type_id LIKE concat('%', :type_id, '%')" +
                    "              AND c.contract_status_id LIKE concat('%', :status_id, '%')" +
                    "              AND (CASE" +
                    "                                WHEN :from_date = '' AND :to_date = '' THEN c.start_date LIKE '%%'" +
                    "                              WHEN :from_date = ''  AND :to_date != '' THEN c.start_date = :to_date" +
                    "                                  WHEN :to_date = ''  AND :from_date != '' THEN c.start_date = :from_date" +
                    "                                   ELSE c.start_date BETWEEN COALESCE(:from_date, c.start_date) AND COALESCE(:to_date, c.start_date)" +
                    "                            END)"
            , nativeQuery = true)
    Page<ITransactionHistoryProjection> searchTransactionHistory(Pageable pageable,
                                                                 @Param("customer_name") String customerName,
                                                                 @Param("product_names") String productNames,
                                                                 @Param("from_date") String fromDate,
                                                                 @Param("to_date") String toDate,
                                                                 @Param("type_id") String typeId,
                                                                 @Param("status_id") String statusId);

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


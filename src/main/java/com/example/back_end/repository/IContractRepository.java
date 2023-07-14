package com.example.back_end.repository;


import com.example.back_end.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contracts,Integer> {
    @Query(value = "SELECT p FROM Contracts AS p")
    List<Contracts> findAllContracts();
    @Transactional
    @Modifying
    @Query(value ="INSERT INTO contracts(customer_id,contract_code,product_name,product_type_id,image,loans,start_date,end_date,profit,contract_status_id,contract_type_id,employee_id) " +
            "VALUES (:customerId,:contractCode,:productName,:productTypeId,:image,:loans,:startDate,:endDate,:profit,:contractStatusId,:contractTypeId,:employeeId)",nativeQuery = true)
    void createContract(@Param("customerId")Long customerId,@Param("contractCode")String contractCode,
                      @Param("productName")String productName,@Param("productTypeId")Long productTypeId,
                      @Param("image")String image,@Param("loans")Long loans,@Param("startDate") String startDate,
                      @Param("endDate") String endDate,@Param("profit") Long profit,@Param("contractStatusId")Long contractStatusId,
                      @Param("contractTypeId")Long contractTypeId,@Param("employeeId")Long employeeId);
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
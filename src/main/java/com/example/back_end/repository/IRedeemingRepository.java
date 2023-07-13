package com.example.back_end.repository;

import com.example.back_end.dto.open_contract.IOpenContractDTO;
import com.example.back_end.dto.open_contract.OpenContractDTO;
import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedeemingRepository extends JpaRepository<Contracts, Long> {
    @Modifying
    @Query(value = "UPDATE contracts SET contract_status_id = 2, redeem_date = :redeemDate WHERE id = :id", nativeQuery = true)
    void redeem(@Param("id") Long id, @Param("redeemDate") String redeemDate);


    @Query(value = "SELECT con.id AS contractId,con.contract_code AS contractCode, c.name AS customerName, con.product_name AS productName, con.start_date AS startDate, con.loans AS loans\n" +
            "FROM contracts AS con\n" +
            "         INNER JOIN contract_status cs ON con.contract_status_id = cs.id\n" +
            "         INNER JOIN customers c ON con.customers_id = c.id\n" +
            "WHERE con.is_delete = FALSE\n" +
            "  AND con.contract_status_id = 1 ORDER BY con.create_time DESC"
            , nativeQuery = true)
    Page<IOpenContractDTO> findPageConTract(@Param("page") Pageable page);


    @Query(value = "SELECT *\n" +
            "FROM contracts\n" +
            "         INNER JOIN customers c ON contracts.customers_id = c.id\n" +
            "WHERE contracts.id = 1\n" +
            "  AND contracts.is_delete = FALSE\n" +
            "  AND contracts.contract_status_id = 1", nativeQuery = true)
    Contracts findOpenContractById(Long id);


    @Query(value = "SELECT con.id            AS contractId,\n" +
            "       con.contract_code AS contractCode,\n" +
            "       c.name            AS customerName,\n" +
            "       con.product_name  AS productName,\n" +
            "       con.start_date    AS startDate,\n" +
            "       con.loans         AS loans\n" +
            "FROM contracts AS con\n" +
            "         INNER JOIN contract_status cs ON con.contract_status_id = cs.id\n" +
            "         INNER JOIN customers c ON con.customers_id = c.id\n" +
            "WHERE con.is_delete = FALSE\n" +
            "  AND con.contract_status_id = 1\n" +
            "  AND con.contract_code LIKE :contractCode AND c.name LIKE :customerName AND con.product_name LIKE :productName AND start_date LIKE :startDate\n" +
            "ORDER BY con.create_time DESC", nativeQuery = true)
    Page<IOpenContractDTO> searchPageConTract(Pageable pageable,@Param("contractCode") String contractCode,@Param("customerName") String customerName,@Param("productName") String productName,@Param("startDate") String startDate);
}

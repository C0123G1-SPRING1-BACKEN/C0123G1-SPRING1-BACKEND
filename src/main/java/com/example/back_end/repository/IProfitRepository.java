package com.example.back_end.repository;

import com.example.back_end.dto.IProfitForesee;
import com.example.back_end.dto.IProfitInterest;
import com.example.back_end.dto.IProfitLiquidation;
import com.example.back_end.dto.ProfitInterestDTO;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.Liquidations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProfitRepository extends JpaRepository<Contracts, Long> {

    @Query(value = "select " +
            "c.contract_code as contractCode," +
            "c.loans as loans," +
            "c.profit as interest," +
            "c.profit as profit  from contracts as c " +
            " inner join contract_status cs on c.contract_status_id = cs.id " +
            "where cs.id = 3 and ( \n" +
            "    CASE \n" +
            "        WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
            "        WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
            "        WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
            "        WHEN :startDate != '' and :endDate != '' then (c.start_date >= :startDate and c.start_date <= :endDate)\n" +
            "        END \n" +
            "    )",
            countQuery = "select count(*) from contracts as c " +
                    " inner join contract_status cs on c.contract_status_id = cs.id " +
                    "where cs.id = :contractStatusId and ( \n" +
                    "    CASE \n" +
                    "        WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
                    "        WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
                    "        WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
                    "        WHEN :startDate != '' and :endDate != '' then (c.start_date >= :startDate and c.start_date <= :endDate)\n" +
                    "        END \n" +
                    "    )", nativeQuery = true)
    Page<IProfitInterest> getAllContractInterest(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable);

    @Query(value = "select " +
            "c.contract_code as contractCode," +
            "c.loans as loans," +
            "c.profit  as interest," +
            "c.start_date as startDate," +
            "c.end_date as endDate," +
            "c.profit as profitForesee  from contracts as c " +
            " inner join contract_status cs on c.contract_status_id = cs.id " +
            "where cs.id = 2 and ( \n" +
            "    CASE \n" +
            "        WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
            "        WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
            "        WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
            "        WHEN :startDate != '' and :endDate != '' then (c.start_date >= :startDate and c.start_date <= :endDate)\n" +
            "        END\n" +
            "    )",
            countQuery = "select count(*) from contracts as c " +
                    " inner join contract_status cs on c.contract_status_id = cs.id " +
                    "where cs.id = :contractStatusId and ( \n" +
                    "    CASE \n" +
                    "        WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
                    "        WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
                    "        WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
                    "        WHEN :startDate != '' and :endDate != '' then (c.start_date >= :startDate and c.start_date <= :endDate)\n" +
                    "        END \n" +
                    "    )", nativeQuery = true)
    Page<IProfitForesee> getAllContractForesee(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable);

    @Query(value = "select c.contract_code      as contractCode,\n" +
            "       c.loans              as loans,\n" +
            "       (c.profit + c.loans) as proceedsOfSale,\n" +
            "       c.profit as profit\n" +
            "from liquidations as l\n" +
            "         inner join contracts c on l.contracts_id = c.id\n" +
            "where CASE\n" +
            "          WHEN :startDate = '' and :endDate = '' THEN l.create_time LIKE '%%'\n" +
            "          WHEN :startDate = '' THEN l.create_time LIKE concat('%', :endDate, '%')\n" +
            "          WHEN :endDate = '' THEN l.create_time LIKE concat('%', :startDate, '%')\n" +
            "          WHEN :startDate != '' and :endDate != '' then (l.create_time >= :startDate and l.create_time <= :endDate)\n" +
            "          END",
            countQuery = "select count(*) from liquidations as l \n" +
                    " inner join contracts c on l.contracts_id = c.id \n" +
                    "where CASE \n" +
                    "WHEN :startDate = '' and :endDate = '' THEN l.create_time LIKE '%%' \n" +
                    "WHEN :startDate = '' THEN l.create_time LIKE concat('%', :endDate, '%') \n" +
                    "WHEN :endDate = '' THEN l.create_time LIKE concat('%', :startDate, '%') \n" +
                    "WHEN :startDate != '' and :endDate != '' then (l.create_time >= :startDate and l.create_time <= :endDate) \n" +
                    "END", nativeQuery = true)
    Page<IProfitLiquidation> getAllLiquidation(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable);


    @Query(value = "select sum(c.profit)\n" +
            "from contracts c\n" +
            "inner join contract_status cs on c.contract_status_id = cs.id \n" +
            "where cs.id = :contractStatusId and ( \n" +
            "    CASE \n" +
            "        WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
            "        WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
            "        WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
            "        WHEN :startDate != '' and :endDate != '' then (c.start_date >= :startDate and c.start_date <= :endDate) \n" +
            "        END\n" +
            "    )", nativeQuery = true)
    Long getTotalProfitContract(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("contractStatusId") Long contractStatusId);

    @Query(value = "select sum(c.profit) \n" +
            "from liquidations l \n" +
            "         inner join contracts c on l.contracts_id = c.id \n" +
            "where l.create_time between :startDate and :endDate", nativeQuery = true)
    Long getTotalProfitLiquidation(@Param("startDate") String startDate, @Param("endDate") String endDate);
}

package com.example.back_end.repository;

import com.example.back_end.dto.*;
import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfitRepository extends JpaRepository<Contracts, Long> {

    @Query(value = "select " +
            "c.contract_code as contractCode," +
            "c.loans as loans," +
            "c.profit as interest," +
            "c.start_date as startDate," +
            "c.profit as profit  from contracts as c " +
            " inner join contract_status cs on c.contract_status_id = cs.id " +
            "where cs.id = 3  and year(c.start_date) like :currentYear and  ( \n" +
            "    CASE \n" +
            "WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
            "WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
            "WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
            "WHEN :startDate != '' and :endDate != '' then c.start_date between COALESCE(:startDate,c.start_date) and COALESCE(:endDate,c.start_date)\n" +
            "        END \n" +
            "    ) ORDER BY c.start_date DESC",
            countQuery = "select count(*) from contracts as c " +
                    " inner join contract_status cs on c.contract_status_id = cs.id " +
                    "where cs.id = 3  and year(c.start_date) like :currentYear and ( \n" +
                    "    CASE \n" +
                    "WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
                    "WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
                    "WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
                    "WHEN :startDate != '' and :endDate != '' then c.start_date between COALESCE(:startDate,c.start_date) and COALESCE(:endDate,c.start_date)\n" +
                    "        END \n" +
                    "    )", nativeQuery = true)
    Page<IProfitInterest> getAllContractInterest(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable,@Param("currentYear") String currentYear);

    @Query(value = "select " +
            "c.contract_code as contractCode," +
            "c.loans as loans," +
            "c.profit  as interest," +
            "c.start_date as startDate," +
            "c.end_date as endDate," +
            "c.profit as profitForesee  " +
            "from contracts as c \n" +
            " inner join contract_status cs on c.contract_status_id = cs.id \n" +
            "where cs.id = 2 and year(c.start_date) like :currentYear and ( \n" +
            "    CASE \n" +
            "WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
            "WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
            "WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
            "WHEN :startDate != '' and :endDate != '' then c.start_date between COALESCE(:startDate,c.start_date) and COALESCE(:endDate,c.start_date)\n" +
            "        END\n" +
            "    )ORDER BY c.start_date DESC",
            countQuery = "select count(*) from contracts as c " +
                    " inner join contract_status cs on c.contract_status_id = cs.id " +
                    "where cs.id = 2 and year(c.start_date) like :currentYear and ( \n" +
                    "    CASE \n" +
                    "WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
                    "WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
                    "WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
                    "WHEN :startDate != '' and :endDate != '' then c.start_date between COALESCE(:startDate,c.start_date) and COALESCE(:endDate,c.start_date)\n" +
                    "        END \n" +
                    "    )", nativeQuery = true)
    Page<IProfitForesee> getAllContractForesee(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable,@Param("currentYear") String currentYear);

    @Query(value = "select c.contract_code as contractCode,\n" +
            "                   c.loans as loans,\n" +
            "                   (c.loans + c.profit) as proceedsOfSale,\n" +
            "                   c.start_date as createDate,\n" +
            "                   c.profit as profit\n" +
            "            from contracts c\n" +
            "            inner join contract_status cs on c.contract_status_id = cs.id\n" +
            "            where cs.id = 5 and year(c.start_date) like :currentYear\n" +
            "              and CASE\n" +
            "                      WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%'\n" +
            "                      WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%')\n" +
            "                      WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%')\n" +
            "                      WHEN :startDate != '' and :endDate != ''\n" +
            "                          then c.start_date between COALESCE(:startDate, c.start_date) and COALESCE(:endDate, c.start_date)\n" +
            "                END",
            countQuery = "select count(*) from contracts as c \n" +
                    "            inner join contract_status cs on c.contract_status_id = cs.id\n" +
                    "            where cs.id = 5 and year(c.start_date) like :currentYear\n" +
                    "              and CASE\n" +
                    "                      WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%'\n" +
                    "                      WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%')\n" +
                    "                      WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%')\n" +
                    "                      WHEN :startDate != '' and :endDate != ''\n" +
                    "                          then c.start_date between COALESCE(:startDate, c.start_date) and COALESCE(:endDate, c.start_date)\n" +
                    "                END", nativeQuery = true)
    Page<IProfitLiquidation> getAllLiquidation(@Param("startDate") String startDate, @Param("endDate") String endDate, Pageable pageable,@Param("currentYear") String currentYear);

    @Query(value = "select month(c.start_date) as month,\n" +
            "       sum(c.profit)       as profit\n" +
            "from contracts as c " +
            " inner join contract_status cs on c.contract_status_id = cs.id \n" +
            "where cs.id = :contractStatusId and year(c.start_date) like :currentYear and CASE\n" +
            "WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%'\n" +
            "WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%')\n" +
            "WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%')\n" +
            "WHEN :startDate != '' and :endDate != '' then c.start_date between COALESCE(:startDate,c.start_date) and COALESCE(:endDate,c.start_date)\n" +
            "          END\n" +
            "GROUP BY month(c.start_date)" +
            "ORDER BY month ASC", nativeQuery = true)
    List<IStatistics> statisticsProfit(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("contractStatusId") Long contractStatusId,@Param("currentYear") String currentYear);

    @Query(value = " select month(c.start_date) as month,\n" +
            "       sum(c.loans)        as profit\n" +
            "from contracts c\n" +
            "inner join contract_status cs on c.contract_status_id = cs.id\n" +
            "where cs.id = 5 and year(c.start_date) like :currentYear\n" +
            "  and CASE\n" +
            "          WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%'\n" +
            "          WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%')\n" +
            "          WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%')\n" +
            "          WHEN :startDate != '' and :endDate != ''\n" +
            "              then c.start_date between COALESCE(:startDate, c.start_date) and COALESCE(:endDate, c.start_date)\n" +
            "    END\n" +
            "GROUP BY month(c.start_date)\n" +
            "ORDER BY month ASC", nativeQuery = true)
    List<IStatistics> statisticsProfitLiquidation(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("currentYear") String currentYear);

    @Query(value = "select sum(c.profit)\n" +
            "from contracts c\n" +
            "inner join contract_status cs on c.contract_status_id = cs.id \n" +
            "where cs.id = :contractStatusId  and year(c.start_date) like :currentYear and ( \n" +
            "    CASE \n" +
            "WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%' \n" +
            "WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%') \n" +
            "WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%') \n" +
            "WHEN :startDate != '' and :endDate != '' then c.start_date between COALESCE(:startDate,c.start_date) and COALESCE(:endDate,c.start_date) \n" +
            "        END\n" +
            "    )", nativeQuery = true)
    Long getTotalProfitContract(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("contractStatusId") Long contractStatusId,@Param("currentYear") String currentYear);

    @Query(value = "select sum(c.profit)\n" +
            "       from contracts c\n" +
            "       inner join contract_status cs on c.contract_status_id = cs.id \n" +
            "       where cs.id = 5 and year(c.start_date) like :currentYear \n" +
            "       and CASE\n" +
            "       WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%'\n" +
            "       WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%')\n" +
            "       WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%')\n" +
            "       WHEN :startDate != '' and :endDate != ''\n" +
            "       then c.start_date between COALESCE(:startDate, c.start_date) and COALESCE(:endDate, c.start_date)\n" +
            "    END", nativeQuery = true)
    Long getTotalProfitLiquidation(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("currentYear") String currentYear);
}

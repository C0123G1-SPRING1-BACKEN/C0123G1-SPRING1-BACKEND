package com.example.back_end.repository;

import com.example.back_end.dto.ProfitInterestDTO;
import com.example.back_end.model.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProfitRepository extends JpaRepository<Contracts, Long> {
    @Query(value = "select * from contracts as c " +
            " inner join contract_status cs on c.contract_status_id = cs.id " +
            "where cs.id = :contractStatusId", nativeQuery = true)
    Page<ProfitInterestDTO> getAllContract(Pageable pageable,@Param("contractStatusId") Long contractStatusId);

    @Query(value = "select sum(c.profit)\n" +
            "from contracts c\n" +
            "inner join contract_status cs on c.contract_status_id = cs.id\n" +
            "where cs.id = :contractStatusId and (\n" +
            "    CASE\n" +
            "        WHEN :startDate = '' and :endDate = '' THEN c.start_date LIKE '%%'\n" +
            "        WHEN :startDate = '' THEN c.start_date LIKE concat('%', :endDate, '%')\n" +
            "        WHEN :endDate = '' THEN c.start_date LIKE concat('%', :startDate, '%')\n" +
            "        WHEN :startDate != '' and :endDate != '' then (c.start_date >= :startDate and c.start_date <= :endDate)\n" +
            "        END\n" +
            "    )", nativeQuery = true)
    Long getTotalContract(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("contractStatusId") Long contractStatusId);

//    @Query(value = "select * from contracts as c " +
//            " inner join contract_status cs on c.contract_status_id = cs.id where cs.id = 2", nativeQuery = true)
//    Page<Contracts> getAllContractForesee(Pageable pageable);

//    @Query(value = "select * from liquidations as c ", nativeQuery = true)
//    Page<Contracts> getAllLiquidation(Pageable pageable);
}

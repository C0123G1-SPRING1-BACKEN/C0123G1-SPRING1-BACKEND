package com.example.back_end.repository;

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
    @Query(value = "UPDATE contracts SET contract_status_id = 2 WHERE id = :id",nativeQuery = true)
    void redeem(@Param("id") Long id);



    @Query(value = "SELECT * FROM contracts WHERE contract_status_id = 1 order by create_time desc",nativeQuery = true)
    Page<Contracts> findPageConTract(@Param("page") Pageable page);
}

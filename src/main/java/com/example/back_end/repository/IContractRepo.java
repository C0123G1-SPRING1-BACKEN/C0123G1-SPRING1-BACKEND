package com.example.back_end.repository;

import com.example.back_end.model.Contracts;
import com.example.back_end.dto.StockDTO;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepo extends JpaRepository<Contracts,Long> {
    @Query(value ="SELECT c.id,c.product_name,c.product_type_id,c.contract_status_id,c.loans FROM contracts as c WHERE c.contract_status_id = 1 ",nativeQuery = true)
    Page<StockDTO> findAllContract(Pageable pageable);
    @Query(value = "SELECT c.id,c.product_name,c.product_type_id,c.contract_status_id,c.loans FROM contracts as c where c.product_name like concat('%',:name,'%') AND c.product_type_id like concat('%',:type,'%')",nativeQuery = true)
    Page<Contracts> findProductInStock(@Param("name") String name, @Param("type") String phone, Pageable pageable);

}

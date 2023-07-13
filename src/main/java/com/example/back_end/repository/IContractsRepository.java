package com.example.back_end.repository;

import com.example.back_end.dto.ContractsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractsRepository extends JpaRepository<ContractsDto,Long> {
//    @Query(value = "select ")
}

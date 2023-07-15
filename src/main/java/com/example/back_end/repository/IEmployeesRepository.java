package com.example.back_end.repository;

import com.example.back_end.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeesRepository extends JpaRepository<Employees,Long> {
    @Query(value = "select * employees",nativeQuery = true)
    List<Employees> getAll();
}

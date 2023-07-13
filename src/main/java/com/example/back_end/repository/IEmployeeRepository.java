package com.example.back_end.repository;


import com.example.back_end.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository  extends JpaRepository<Employees,Integer> {
    @Query(value = "SELECT p FROM Employees AS p")
    List<Employees> findAll();
}

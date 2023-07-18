package com.example.back_end.repository;

import com.example.back_end.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeesRepository extends JpaRepository<Employees, Long> {
    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list employees into Database
     *   @param
     *      @return list
     *
     */
    @Query(value = "select * from employees",nativeQuery = true)
    List<Employees> getAllEmployees();
}

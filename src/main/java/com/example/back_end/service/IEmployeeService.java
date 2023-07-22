package com.example.back_end.service;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.model.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {

    Page<EmployeeDTO> findAllByName(Pageable pageable, String search);

    /**
     * Created by: DongPV
     * Date created: 13/07/2023
     * function: Create employee
     * @param employeeDTO
     */
    void createEmployee(EmployeeDTO employeeDTO);

    Employees findById(int id);
}

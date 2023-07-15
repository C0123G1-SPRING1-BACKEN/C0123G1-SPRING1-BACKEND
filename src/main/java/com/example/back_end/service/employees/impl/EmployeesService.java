package com.example.back_end.service.employees.impl;

import com.example.back_end.model.Employees;
import com.example.back_end.repository.IEmployeesRepository;
import com.example.back_end.service.employees.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService implements IEmployeesService {
    @Autowired
    private IEmployeesRepository iEmployeesRepository;

    @Override
    public List<Employees> getAllEmployees() {
        return iEmployeesRepository.getAll();
    }
}

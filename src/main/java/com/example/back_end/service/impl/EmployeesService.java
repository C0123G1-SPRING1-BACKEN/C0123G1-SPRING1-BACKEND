package com.example.back_end.service.impl;

import com.example.back_end.model.Employees;
import com.example.back_end.repository.IEmployeesRepository;
import com.example.back_end.service.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeesService implements IEmployeesService {
    /**
     * Created by: HuyNH
     * Date created: 13/07/2023
     * Function: display list employees into Database
     *   @param
     *      @return list
     *
     */
    @Autowired
    private IEmployeesRepository iEmployeesRepository;
    @Override
    public List<Employees> getAllEmployees() {
        return iEmployeesRepository.getAllEmployees();
    }
}

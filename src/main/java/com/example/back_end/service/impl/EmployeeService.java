package com.example.back_end.service.impl;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.model.Employees;
import com.example.back_end.repository.IEmployeeRepository;
import com.example.back_end.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<EmployeeDTO> findAllByName(Pageable pageable, String search) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        Page<Employees> employeePage = iEmployeeRepository.findAllByNameContaining(pageable, search);
        EmployeeDTO employeeDTO;
        for (Employees employees : employeePage){
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employees,employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return new PageImpl<>(employeeDTOList, pageable, employeePage.getTotalElements());
    }


    /**
     * Created by: DongPV
     * Date created: 13/07/2023
     * function: Create employee
     */
    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employees employees = new Employees();
        BeanUtils.copyProperties(employeeDTO, employees);
        iEmployeeRepository.createEmployee(
                employees.getName(),
                employees.getBirthDay(),
                employees.getGender(),
                employees.getEmail(),
                employees.getPhoneNumber(),
                employees.getAddress(),
                employees.getSalary(),
                employees.getCitizenCode(),
                employees.getImage()
        );
    }
}

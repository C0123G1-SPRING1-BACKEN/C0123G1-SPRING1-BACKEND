package com.example.back_end.service.impl;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.model.Employee;
import com.example.back_end.model.Users;
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
        Page<Employee> employeePage = iEmployeeRepository.findAllByNameContaining(pageable, search);
        EmployeeDTO employeeDTO;
        for (Employee employee : employeePage){
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee,employeeDTO);
            employeeDTOList.add(employeeDTO);
        }
        return new PageImpl<>(employeeDTOList, pageable, employeePage.getTotalElements());
    }


    /**
     * Created by: DongPV
     * Date created: 13/07/2023
     * function: Create employee
     *
     */
    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        iEmployeeRepository.createEmployee(
                employee.getName(),
                employee.getBirthDay(),
                employee.getGender(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getCitizenCode(),
                employee.getImage()
        );
    }
}

package com.example.back_end.service.details.impl;

import com.example.back_end.dto.EmployeeDetailDto;
import com.example.back_end.model.Employees;
import com.example.back_end.repository.IEmployeeDetailRepository;
import com.example.back_end.service.details.IEmployeeDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailServiceImpl implements IEmployeeDetailService {
    @Autowired
    private IEmployeeDetailRepository employeeDetailRepository;

    /**
     * Create by: DatNT,
     * Date create : 19/07/2023
     * Function : connect database to update employee with corresponding id of employee
     *
     * @param id, employeeSaveDto
     */
    @Override
    public void updateEmployeeDetail(Long id, EmployeeDetailDto employeeDetailDto) {
        Employees employees = new Employees();
        BeanUtils.copyProperties(employeeDetailDto, employees);
        employeeDetailRepository.updateEmployee(
                employees.getId(),
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

    /**
     * Create by: DatNT,
     * Date create : 19/07/2023
     * Function : connect database to detail employee find by id detail employee
     *
     * @param email
     * @return employeeSaveDto
     */
    @Override
    public EmployeeDetailDto findByEmailEmployee(String email) {
        Employees employees = employeeDetailRepository.findWithEmailEmployee(email);
        EmployeeDetailDto employeeDetailDto =new EmployeeDetailDto();
        BeanUtils.copyProperties(employees, employeeDetailDto);
        return employeeDetailDto;
    }

    /**
     * Create by: DatNT,
     * Date create : 19/07/2023
     * Function : connect database to employee find by email check duplicate
     *
     * @param email
     * @return boolean
     */
    @Override
    public boolean existsByEmail(String email) {
        return employeeDetailRepository.existsByEmail(email);
    }

    /**
     * Create by: DatNT,
     * Date create : 19/07/2023
     * Function : connect database to employee find by citizenCode check duplicate
     *
     * @param citizenCode
     * @return boolean
     */
    @Override
    public boolean existsByCitizenCode(String citizenCode) {
        return employeeDetailRepository.existsByCitizenCode(citizenCode);
    }

    /**
     * Create by: DatNT,
     * Date create : 19/07/2023
     * Function : connect database to employee find by phoneNumber check duplicate
     *
     * @param phoneNumber
     * @return boolean
     */
    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return employeeDetailRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public EmployeeDetailDto findId(Long id) {
        Employees employees = employeeDetailRepository.findById(id).orElse(null);
        EmployeeDetailDto employeeDetailDto =new EmployeeDetailDto();
        assert employees != null;
        BeanUtils.copyProperties(employees, employeeDetailDto);
        return employeeDetailDto;
    }
}

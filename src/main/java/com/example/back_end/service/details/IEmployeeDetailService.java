package com.example.back_end.service.details;

import com.example.back_end.dto.EmployeeDetailDto;

public interface IEmployeeDetailService {

    void updateEmployeeDetail(Long id, EmployeeDetailDto employeeDetailDto);

    EmployeeDetailDto findByEmailEmployee(String email);

    boolean existsByEmail(String email);

    boolean existsByCitizenCode(String citizenCode);

    boolean existsByPhoneNumber(String phoneNumber);

    EmployeeDetailDto findId(Long id);
}

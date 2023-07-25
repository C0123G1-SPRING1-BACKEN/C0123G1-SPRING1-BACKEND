package com.example.back_end.service.details;

import com.example.back_end.dto.EmployeeDetailDto;

public interface IEmployeeDetailService {

    void updateEmployeeDetail(Long id, EmployeeDetailDto employeeDetailDto);

    EmployeeDetailDto findByIdEmployee(Long id);

    boolean existsByEmail(String email);

    boolean existsByCitizenCode(String citizenCode);

    boolean existsByPhoneNumber(String phoneNumber);
}

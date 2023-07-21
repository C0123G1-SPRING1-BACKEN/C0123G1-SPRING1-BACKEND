package com.example.back_end.controller;

import com.example.back_end.dto.EmployeeDetailDto;
import com.example.back_end.service.details.IEmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employee")
public class EmployeeDetailController {
    @Autowired
    private IEmployeeDetailService employeeDetailService;

    @GetMapping("detail/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<?> detailEmployee(@PathVariable Long id) {
        EmployeeDetailDto employeeDetailDto = employeeDetailService.findId(id);
        if (employeeDetailDto == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(employeeDetailDto, HttpStatus.OK);
    }

    @PatchMapping("detail/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public ResponseEntity<?> updateEmployee(@Validated @RequestBody EmployeeDetailDto employeeDetailDto, BindingResult bindingResult, @PathVariable Long id) {
        if (!bindingResult.hasErrors()) {
            employeeDetailService.updateEmployeeDetail(id, employeeDetailDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            getResponseEntity(bindingResult);
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
    }

    private void getResponseEntity(BindingResult bindingResult) {
        Map<String, String> map = new LinkedHashMap<>();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            if (!map.containsKey(error.getField())) {
                map.put(error.getField(), error.getDefaultMessage());
            }
        }
    }
}

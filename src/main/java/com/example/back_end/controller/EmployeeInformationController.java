package com.example.back_end.controller;


import com.example.back_end.dto.EmployeeDetailDto;
import com.example.back_end.service.details.IEmployeeDetailService;
import com.example.back_end.service.impl.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeInformationController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private IEmployeeDetailService employeeDetailService;

//    @GetMapping("/detail")
//    public ResponseEntity<?> getEmployeeDetails(HttpServletRequest request) {
//        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (username == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bạn cần đăng nhập hệ thống.");
//        }
//
//        Users user = usersService.findByUsername(username);
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Không tìm thấy tài khoản.");
//        }
//        EmployeeDetailDto employeeDetailDto = employeeDetailService.findByEmailEmployee(user.getEmail());
//        if (employeeDetailDto != null) {
//            return ResponseEntity.ok(employeeDetailDto);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailEmployee(@PathVariable Long id) {
        EmployeeDetailDto employeeDetailDto = employeeDetailService.findId(id);
        if (employeeDetailDto == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(employeeDetailDto, HttpStatus.OK);
    }

    @PatchMapping("detail/{id}")
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

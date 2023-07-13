package com.example.back_end.controller;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<Page<EmployeeDTO>> findAllByName(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC, size = 5)Pageable pageable,
                                                           @RequestParam(required = false,defaultValue = "") String search){
        Page<EmployeeDTO> employeeDTOS = iEmployeeService.findAllByName(pageable,search);
        if (employeeDTOS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeDTOS,HttpStatus.OK);
    }

    /**
     * Created by: DongPV
     * Date created: 13/07/2023
     * Function: create data employee  into Database
     * @param employeeDTO
     * @param bindingResult
     * @return HttpStatus.BAD_REQUEST,HttpStatus.OK
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-employee")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        iEmployeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

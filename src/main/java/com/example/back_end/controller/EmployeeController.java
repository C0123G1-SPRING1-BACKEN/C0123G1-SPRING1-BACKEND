package com.example.back_end.controller;

import com.example.back_end.dto.EmployeeDTO;
import com.example.back_end.repository.IEmployeeRepository;
import com.example.back_end.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * created by : DongPV
     * Date created : 13/07/2023
     * @param pageable
     * @param search
     * @return HttpStatus.BAD_REQUEST , HttpStatus.OK
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EmployeeDTO> createEmployee(@Validated @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iEmployeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/check-email/{email}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Boolean> checkEmailExistence(@PathVariable("email") String email) {
        boolean exists = iEmployeeRepository.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/check-citizen-code/{citizen-code}")
    public ResponseEntity<Boolean> checkCitizenCodeExistence(@PathVariable("citizen-code") String citizenCode) {
        boolean exists = iEmployeeRepository.existsByCitizenCode(citizenCode);
        return ResponseEntity.ok(exists);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/check-phone/{phone-number}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Boolean> checkPhoneExistence(@PathVariable("phone-number") String phoneNumber) {
        boolean exists = iEmployeeRepository.existsByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(exists);
    }
}

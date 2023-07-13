package com.example.back_end.controller;

import com.example.back_end.dto.ICustomerDto;
import com.example.back_end.model.Customers;
import com.example.back_end.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Created by: DinhHD
 * Date created: 13/07/2023
 * Function: do about customer selection interface
 *
 // * @param Customer
 * @return getAllCustomer(),searchCustomer()
 */

@RestController
    @RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public ResponseEntity<Page<ICustomerDto>> getAllCustomer(@PageableDefault(size = 3) Pageable pageable) {
        Page<ICustomerDto> iCustomerDtoPage = iCustomerService.findByCustomer(pageable);
        return new ResponseEntity<>(iCustomerDtoPage, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<ICustomerDto>> searchCustomer(@PageableDefault(size = 3) Pageable pageable,@RequestParam("name")String name) {
        Page<ICustomerDto> iCustomerDtoPage = iCustomerService.searchCustomer(pageable,name);
        return new ResponseEntity<>(iCustomerDtoPage, HttpStatus.OK);
    }
}

package com.example.back_end.controller;

import com.example.back_end.dto.CustomersDto;
import com.example.back_end.service.customers.ICustomerService;
import com.example.back_end.service.liquidations.ILiquidationsService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by: KhangPVA
 * Date created: 13/07/2023
 * Function: create liquidation
 *
 * @param
 * @return
 */


@RestController
@RequestMapping("/api/employee/liquidation")
@CrossOrigin("*")
public class LiquidationRestController {
    @Autowired
    private ILiquidationsService liquidationsService;
    @Autowired
    private ICustomerService customerService;

//    @PostMapping("")
//    public void createLiquidation(@RequestBody Liquidations liquidations) {
//        liquidationsService.save(liquidations);
//    }

    @GetMapping("/customers")
    public ResponseEntity<Page<CustomersDto>> getList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CustomersDto> customersPage = customerService.findAllCustomer(pageable);
        HttpHeaders headers = new HttpHeaders();
        headers.add("customerPage", String.valueOf(customersPage.getTotalPages()));
        headers.add("customerElement", String.valueOf(customersPage.getTotalElements()));
        return ResponseEntity.ok().headers(headers).body(customersPage);
    }
}

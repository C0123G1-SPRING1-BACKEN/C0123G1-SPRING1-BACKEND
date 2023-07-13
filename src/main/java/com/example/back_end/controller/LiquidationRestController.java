package com.example.back_end.controller;

import com.example.back_end.dto.ContractsDto;
import com.example.back_end.dto.CustomersDto;
import com.example.back_end.model.Liquidations;
import com.example.back_end.service.contracts.IContractsService;
import com.example.back_end.service.customers.ICustomerService;
import com.example.back_end.service.liquidations.ILiquidationsService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by: KhangPVA
 * Date created: 13/07/2023
 * Function: create liquidation
 *
 * @param LiquidationDto
 * @return Liquidation
 */

@RestController
@RequestMapping("/api/employee/liquidation")
@CrossOrigin("*")
public class LiquidationRestController {
    @Autowired
    private ILiquidationsService liquidationsService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IContractsService contractsService;

    @PostMapping("")
    public void createLiquidation(@RequestBody Liquidations liquidations) {
        liquidationsService.save(liquidations);
    }

    @GetMapping("/customers")
    public ResponseEntity<Page<CustomersDto>> getListCustomer(@PageableDefault(size = 3)Pageable pageable){
        Page<CustomersDto> customersDtoPage=customerService.findAllCustomer(pageable);
        if(customersDtoPage.isEmpty()){
            return new ResponseEntity<>(customersDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customersDtoPage,HttpStatus.OK);
    }
    @GetMapping("/contracts")
    public ResponseEntity<Page<ContractsDto>> getListProduct(@PageableDefault(size = 3)Pageable pageable){
        Page<ContractsDto> contractsDtoPage=contractsService.findAllProduct(pageable);
        if(contractsDtoPage.isEmpty()){
            return new ResponseEntity<>(contractsDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractsDtoPage,HttpStatus.OK);
    }
}

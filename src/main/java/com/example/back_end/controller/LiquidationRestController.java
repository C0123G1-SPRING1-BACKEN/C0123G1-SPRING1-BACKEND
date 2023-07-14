package com.example.back_end.controller;

import com.example.back_end.dto.ICustomersDto;
import com.example.back_end.dto.IContractDto;
import com.example.back_end.model.Customers;
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
    public ResponseEntity<Page<ICustomersDto>> getListCustomer(@PageableDefault(size = 3) Pageable pageable) {
        Page<ICustomersDto> customersDtoPage = customerService.findAllCustomer(pageable);
        if (customersDtoPage.isEmpty()) {
            return new ResponseEntity<>(customersDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customersDtoPage, HttpStatus.OK);
    }

    @GetMapping("/contracts")
    public ResponseEntity<Page<IContractDto>> getListProduct(@PageableDefault(size = 3) Pageable pageable) {
        Page<IContractDto> contractsDtoPage = contractsService.findAllProduct(pageable);
        if (contractsDtoPage.isEmpty()) {
            return new ResponseEntity<>(contractsDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractsDtoPage, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
        public Customers findById(Long id){
       return customerService.findByIdCustomer(id);
    }

    @GetMapping("/customers/search")
    public ResponseEntity<Page<ICustomersDto>> getCustomer(@PageableDefault(size = 3) Pageable pageable, @RequestParam("name") String name) {
        Page<ICustomersDto> customersDtoPage = customerService.searchCustomer(pageable, name);
        if (customersDtoPage.isEmpty()) {
            return new ResponseEntity<>(customersDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customersDtoPage, HttpStatus.OK);
    }

    @GetMapping("/contracts/{id}")
    public ResponseEntity<IContractDto> findContractById(@PathVariable Long id) {
        IContractDto  customers=contractsService.findContractById(id);
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @GetMapping("/contracts/search")
    public ResponseEntity<Page<IContractDto>> getCustomer(@PageableDefault(size = 3) Pageable pageable, @RequestParam("productName") String productName
            , @RequestParam("productType") String productType, @RequestParam("loans") Long loans) {
        Page<IContractDto> contractDtoPage = contractsService.searchProduct(pageable, productName, productType, loans);
        if (contractDtoPage.isEmpty()) {
            return new ResponseEntity<>(contractDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDtoPage, HttpStatus.OK);
    }
}

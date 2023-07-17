package com.example.back_end.controller;

import com.example.back_end.dto.ICustomerDto;
import com.example.back_end.dto.IContractDto;
import com.example.back_end.dto.LiquidationsDto;
import com.example.back_end.model.Liquidations;
import com.example.back_end.service.ICustomerService;
import com.example.back_end.service.contracts.IContractsService;
import com.example.back_end.service.liquidations.ILiquidationsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by: KhangPVA
 * Date created: 13/07/2023
 * Function: create liquidation
 *
 * @param LiquidaytionDto
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
    public ResponseEntity<?> createLiquidation(@Valid @RequestBody LiquidationsDto liquidationsDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Liquidations liquidations=new Liquidations();
        BeanUtils.copyProperties(liquidationsDto,liquidations);
        liquidationsService.save(liquidations);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<Page<ICustomerDto>> getListCustomer(@PageableDefault(size = 3) Pageable pageable) {
        Page<ICustomerDto> customerDtoPage = customerService.findByCustomer(pageable);
        if (customerDtoPage.isEmpty()) {
            return new ResponseEntity<>(customerDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDtoPage, HttpStatus.OK);
    }

    @GetMapping("/contracts")
    public ResponseEntity<Page<IContractDto>> getListProduct(@PageableDefault(size = 3) Pageable pageable) {
        Page<IContractDto> contractsDtoPage = contractsService.findAllProduct(pageable);
        if (contractsDtoPage.isEmpty()) {
            return new ResponseEntity<>(contractsDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractsDtoPage, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ICustomerDto> getByIdCustomer(@PathVariable("id") Long id) {
        ICustomerDto iCustomerDto=  customerService.findByIdCustomer(id);
        if (iCustomerDto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iCustomerDto,HttpStatus.OK);
    }

    @GetMapping("/customers/search")
    public ResponseEntity<Page<ICustomerDto>> getCustomer(@PageableDefault(size = 3) Pageable pageable, @RequestParam("name") String name) {
        Page<ICustomerDto> customerDtoPage = customerService.searchCustomer(pageable, name);
        if (customerDtoPage.isEmpty()) {
            return new ResponseEntity<>(customerDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDtoPage, HttpStatus.OK);
    }

    @GetMapping("/contract/{id}")
    public ResponseEntity<IContractDto> getByIdContract(@PathVariable("id") Long id) {
        IContractDto iContractDto=  contractsService.findContractById(id);
        if (iContractDto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iContractDto,HttpStatus.OK);
    }

    @GetMapping("/contracts/search")
    public ResponseEntity<Page<IContractDto>> getCustomer(@PageableDefault(size = 3) Pageable pageable, @RequestParam("productName") String productName
            , @RequestParam("productType") String productType, @RequestParam("loans") Long loans) {
        Page<IContractDto> contractDtoPage = contractsService.searchProduct(pageable, "%"+productName+"%", productType, ("%"+loans+"%"));
        if (contractDtoPage.isEmpty()) {
            return new ResponseEntity<>(contractDtoPage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contractDtoPage, HttpStatus.OK);
    }
}

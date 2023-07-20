package com.example.back_end.controller;


import com.example.back_end.model.*;
import com.example.back_end.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/employee/type")
@RestController
@CrossOrigin("*")
public class ProductTypeRestController {
    @Autowired
    private IProductTypeService iProductTypeService;

    @GetMapping("/contract/productType")
    public ResponseEntity<List<ProductType>> getAll() {
        List<ProductType> kindOfPawnsList = iProductTypeService.getAll();
        return new ResponseEntity<>(kindOfPawnsList, HttpStatus.OK);
    }
    @GetMapping("/contract/contractStatus")
    public ResponseEntity<List<ContractStatus>> getAllContractStatus() {
        List<ContractStatus> contractStatusList = iProductTypeService.getAllContractStatus();
        return new ResponseEntity<>(contractStatusList, HttpStatus.OK);
    }
    @GetMapping("/contract/contractType")
    public ResponseEntity<List<ContractType>> getAllContractType() {
        List<ContractType> contractStatusList = iProductTypeService.getAllContractType();
        return new ResponseEntity<>(contractStatusList, HttpStatus.OK);
    }

}

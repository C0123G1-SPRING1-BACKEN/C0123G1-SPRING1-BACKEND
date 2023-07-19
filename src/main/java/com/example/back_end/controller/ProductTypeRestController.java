package com.example.back_end.controller;


import com.example.back_end.model.*;
import com.example.back_end.repository.IContractStatusRepository;
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
    public ResponseEntity<List<ProductType>> getAllProductType() {
        List<ProductType> productTypeList = iProductTypeService.getAllProductType();
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }
    @GetMapping("/contract/contractType")
    public ResponseEntity<List<ContractType>> getAllEmployee() {
        List<ContractType> contractTypeList = iProductTypeService.getAllContractType();
        return new ResponseEntity<>(contractTypeList, HttpStatus.OK);
    }
    @GetMapping("/contract/contractStatus")
    public ResponseEntity<List<ContractStatus>> getAllContractStatus() {
        List<ContractStatus> contractStatusList = iProductTypeService.getAllContractStatus();
        return new ResponseEntity<>(contractStatusList, HttpStatus.OK);
    }
    @GetMapping("/contract/customers")
    public ResponseEntity<List<Customers>> getAllCustomer(){
        List<Customers> customersList=iProductTypeService.getAllCustomer();
        return new ResponseEntity<>(customersList,HttpStatus.OK);
    }

}

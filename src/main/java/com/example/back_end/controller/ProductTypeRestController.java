package com.example.back_end.controller;


import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.Customers;
import com.example.back_end.model.Employees;
import com.example.back_end.model.ProductType;
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
//
//    @GetMapping("/contract/productType")
//    public ResponseEntity<List<ProductType>> getAll() {
//        List<ProductType> kindOfPawnsList = iProductTypeService.findAll();
//        return new ResponseEntity<>(kindOfPawnsList, HttpStatus.OK);
//    }
//    @GetMapping("/customer")
//    public ResponseEntity<List<Customers>> getAllCustomer() {
//        List<Customers> customerList=iProductTypeService.findAllCustomer();
//        return new ResponseEntity<>(customerList, HttpStatus.OK);
//    }
//    @GetMapping("/contract/employee")
//    public ResponseEntity<List<Employees>> getAllEmployee() {
//        List<Employees> employeesList = iProductTypeService.findAllEmployee();
//        return new ResponseEntity<>(employeesList, HttpStatus.OK);
//    }
//    @GetMapping("/contractStatus")
//    public ResponseEntity<List<ContractStatus>> getAllContractStatus() {
//        List<ContractStatus> contractStatusList = iProductTypeService.findAllContractStatus();
//        return new ResponseEntity<>(contractStatusList, HttpStatus.OK);
//    }

}
